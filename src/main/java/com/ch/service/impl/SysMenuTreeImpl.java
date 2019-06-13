/**
 * Author: 常富文
 * Date:   2019/6/6 9:55
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.entity.*;
import com.ch.service.SysMenuTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class SysMenuTreeImpl implements SysMenuTreeService {
    
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    SysPermissionMapper sysPermissionMapper;
    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;
   
   
   
   
    @Override
    public ResponseResult findSysMenuTree(Long userId) {

        ResponseResult result = new ResponseResult();
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        //List<String> permissionNameList = new ArrayList<>();
        List<SysUserRole> btSysUserRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);
        Set<String> permissionNameList = new HashSet<>();
        if(btSysUserRoles.size()>0){
            SysUserRole userRole = btSysUserRoles.get(0);
            SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
            SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();
            criteria.andRoleIdEqualTo(userRole.getRoleId());
            List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
            for (SysRolePermission sysRolePermission : sysRolePermissions) {
                SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(sysRolePermission.getPermissionId());
                permissionNameList.add(sysPermission.getName());
            }
        }




        try {//查询所有菜单

            //btSysUserRoleMapper.selectByExample(example);

            List<SysMenu> allMenu = sysMenuMapper.selectByExample(null);
            List<SysMenu> collect = allMenu.stream().filter(item -> permissionNameList.contains(item.getLabel())).collect(Collectors.toList());

            //根节点
            List<SysMenu> rootMenu = new ArrayList<SysMenu>();
            for (SysMenu nav : collect) {
                if (nav.getParentId() == 0) {
                    rootMenu.add(nav);
                }
            }
            /* 根据Menu类的order排序 */
            Collections.sort(rootMenu, order());
            //为根菜单设置子菜单，getClild是递归调用的
            for (SysMenu nav : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<SysMenu> childList = getChild(nav.getId(), collect);
                nav.setChildren(childList);//给根节点设置子节点
            }
            /**
             * 输出构建好的菜单数据。
             *
             */
            result.setCode(0);

            result.setData(rootMenu);
            return result;

        } catch (Exception e) {
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("菜单生成异常");
            return result;
        }


    }


    public List<SysMenu> getChild(Integer id, List<SysMenu> allMenu) {
        //子菜单
        List<SysMenu> childList = new ArrayList<SysMenu>();
        for (SysMenu nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if ((nav.getParentId() != null) && nav.getParentId().equals(id)) {
                childList.add(nav);
            }
        }
        //递归
        for (SysMenu nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        Collections.sort(childList, order());//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<SysMenu>();
        }
        return childList;
    }

    public Comparator<SysMenu> order() {
        Comparator<SysMenu> comparator = new Comparator<SysMenu>() {
            @Override
            public int compare(SysMenu o1, SysMenu o2) {
                if (!o1.getSortOrder() .equals(o2.getSortOrder())) {
                    return o1.getSortOrder() - o2.getSortOrder();
                }
                return 0;
            }
        };
        return comparator;
    }
}
