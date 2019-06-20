package com.ch.model;

import java.util.List;

public class RolePermissionDTO {

    private Integer roleId;

    private List<Integer> permissions;


    public List<Integer> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Integer> permissions) {
        this.permissions = permissions;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
