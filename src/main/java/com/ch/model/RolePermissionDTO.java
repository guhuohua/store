package com.ch.model;

import java.util.List;

public class RolePermissionDTO {

    private Integer roleId;

    private List<String> permissions;


    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
