package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.SysRoleMapper;
import com.ch.dao.SysRolePermissionMapper;
import com.ch.dao.SysUserMapper;
import com.ch.dto.RoleDTO;
import com.ch.entity.SysRole;
import com.ch.entity.SysRolePermission;
import com.ch.entity.SysRolePermissionExample;
import com.ch.model.RoleParam;
import com.ch.model.RolePermissionDTO;
import com.ch.model.RolePermissionModel;
import com.ch.service.SysRoleService;
import com.ch.util.DeteUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;


    @Override
    public ResponseResult findRoleList(RoleParam roleParam) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(roleParam.getPageNum(), roleParam.getPageSize());
        List<SysRole> SysRoleList = sysRoleMapper.selectByExample(null);
        for (SysRole sysRole : SysRoleList) {
            sysRole.setForMatTime(DeteUtil.forMat(sysRole.getUpdateTime()));
        }
        PageInfo<SysRole> btSysRolePageInfo = new PageInfo<>(SysRoleList);
        result.setData(btSysRolePageInfo);
        return result;
    }



    @Override
    public ResponseResult insertRole(RoleDTO roleDTO) {
        ResponseResult result = new ResponseResult();
        SysRole btSysRole = new SysRole();
        btSysRole.setRoleName(roleDTO.getRoleName());
        btSysRole.setRoleDesc(roleDTO.getRoleDesc());
        btSysRole.setCreateTime(new Date());
        btSysRole.setParentId(0);
        btSysRole.setUpdateTime(new Date());
        try {
            int insert = sysRoleMapper.insert(btSysRole);
            result.setData(insert > 0 ? true : false);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("新增角色失败");
            result.setData(false);
        }
        return result;

    }

    @Override
    public ResponseResult deleteRoles(Integer roleId ) {
        ResponseResult result = new ResponseResult();

        try {
             sysRoleMapper.deleteByPrimaryKey(roleId);

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("删除角色失败");
            result.setData(false);
        }
        return result;
    }

    @Override
    public ResponseResult editRole(RoleDTO roleDTO) {
        ResponseResult result = new ResponseResult();
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(roleDTO.getRoleId());
        sysRole.setRoleName(roleDTO.getRoleName());
        sysRole.setRoleDesc(roleDTO.getRoleDesc());
        try {
            int delete = sysRoleMapper.update(sysRole);
            result.setData(delete > 0 ? true : false);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("更新角色失败");
            result.setData(false);
        }
        return result;
    }

    @Override
    public ResponseResult findPermissionByRoleId(Integer roleId) {
        ResponseResult result = new ResponseResult();
        List<RolePermissionModel> allMenu = sysUserMapper.findAll();
        List<RolePermissionModel> rolePermissionModels = sysUserMapper.findAllByRoleId(roleId);
        for (RolePermissionModel root : allMenu) {
            root.setRoleId(roleId);
            root.setLabel(root.getPermissionName());
            for (RolePermissionModel children : rolePermissionModels) {
                if (children.getPermissionId().equals(root.getPermissionId())) {
                    root.setChecked(1);
                    root.setLabel(root.getPermissionName());
                }
            }
        }
        //根节点
        List<RolePermissionModel> rootMenu = new ArrayList<RolePermissionModel>();
        for (RolePermissionModel nav : allMenu) {
            if (nav.getParentId() == 0) {
                rootMenu.add(nav);
            }
        }
        /* 根据Menu类的order排序 */
        Collections.sort(rootMenu, order());
        //为根菜单设置子菜单，getClild是递归调用的
        for (RolePermissionModel nav : rootMenu) {
             //获取根节点下的所有子节点 使用getChild方法
             List<RolePermissionModel> childList = getChild(nav.getPermissionId(), allMenu);
            nav.setChildren(childList);//给根节点设置子节点
        }
        result.setData(rootMenu);
        return result;
    }
    public Comparator<RolePermissionModel> order() {
        Comparator<RolePermissionModel> comparator = new Comparator<RolePermissionModel>() {
            @Override
            public int compare(RolePermissionModel o1, RolePermissionModel o2) {
                if (o1.getSortOrder() != o2.getSortOrder()) {
                    return o1.getSortOrder() - o2.getSortOrder();
                }
                return 0;
            }
        };
        return comparator;
    }

    private List<RolePermissionModel> getChild(Integer id, List<RolePermissionModel> allMenu) {
        //子菜单
        List<RolePermissionModel> childList = new ArrayList<RolePermissionModel>();
        for (RolePermissionModel nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if ((nav.getParentId() != null) && nav.getParentId() == Integer.valueOf(id)) {
                childList.add(nav);
            }
        }
        //递归
        for (RolePermissionModel nav : childList) {
            nav.setChildren(getChild(nav.getPermissionId(), allMenu));
        }
        Collections.sort(childList, order());//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<RolePermissionModel>();
        }
        return childList;
    }

    @Override
    public ResponseResult insertPermission(RolePermissionDTO rolePermissionDTO) {
        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(rolePermissionDTO.getRoleId());
        sysRolePermissionMapper.deleteByExample(example);
        ResponseResult result = new ResponseResult();
        Integer roleId = rolePermissionDTO.getRoleId();
        rolePermissionDTO.getPermissions().forEach(item -> {
            SysRolePermission btSysRolePermission = new SysRolePermission();
            btSysRolePermission.setRoleId(roleId);
            btSysRolePermission.setPermissionId(item);
            sysRolePermissionMapper.insert(btSysRolePermission);
        });
        result.setData(true);
        return result;
    }

    @Override
    public ResponseResult roleList() {
        ResponseResult result = new ResponseResult();
        List<SysRole> btSysRoleList = sysRoleMapper.selectByExample(null);
        result.setData(btSysRoleList);
        return result;
    }
}
