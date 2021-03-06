/**
 * Author: 常富文
 * Date:   2019/6/3 17:03
 * Description:
 */

package com.ch.dto;

import com.ch.entity.SysRolePermission;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class UserDTO  implements Serializable {
    private Long userId;
    private String username;
    private String password;

    private Set<String> roles;

    private Set<String> permissions;

    private List<SysRolePermission> sysRolePermissions;

    public List<SysRolePermission> getSysRolePermissions() {
        return sysRolePermissions;
    }

    public void setSysRolePermissions(List<SysRolePermission> sysRolePermissions) {
        this.sysRolePermissions = sysRolePermissions;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
