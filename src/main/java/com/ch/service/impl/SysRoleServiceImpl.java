package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.SysRoleMapper;
import com.ch.dao.SysUserMapper;
import com.ch.dto.RoleDTO;
import com.ch.entity.SysRole;
import com.ch.entity.SysRoleExample;
import com.ch.model.RolePermissionDTO;
import com.ch.model.RolePermissionModel;
import com.ch.model.SysRoleParam;
import com.ch.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class SysRoleServiceImpl implements SysRoleService {

   @Autowired
    SysRoleMapper sysRoleMapper;

   @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public  ResponseResult findRoleList(SysRoleParam sysRoleParam) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysRoleParam.getPageNum(),sysRoleParam.getPageSize());
        List<SysRole> SysRoleList = sysRoleMapper.selectByExample(null);
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
            result.setData(insert > 0 ? true :false);
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
    public ResponseResult deleteRoles(List<Integer> list) {
        ResponseResult result = new ResponseResult();
        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andRoleIdIn(list);
        try {
            int delete = sysRoleMapper.deleteByExample(example);
            result.setData(delete > 0 ? true :false);
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
            int delete =sysRoleMapper.update(sysRole);
            result.setData(delete > 0 ? true :false);
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
        for (RolePermissionModel root: allMenu) {
            root.setRoleId(roleId);
            root.setLabel(root.getPermissionName());
            for (RolePermissionModel children:rolePermissionModels) {
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
       // Collections.sort(rootMenu, order());
        //为根菜单设置子菜单，getClild是递归调用的
        for (RolePermissionModel nav : rootMenu) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
          //  List<RolePermissionModel> childList = getChild(nav.getPermissionId(), allMenu);
            //nav.setChildren(childList);//给根节点设置子节点
        }
        result.setData(rootMenu);
        return result;
    }

    @Override
    public ResponseResult insertPermission(RolePermissionDTO rolePermissionDTO) {
        return null;
    }

    @Override
    public ResponseResult roleList() {
        return null;
    }
}
