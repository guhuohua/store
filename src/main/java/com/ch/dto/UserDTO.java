/**
 * Author: 常富文
 * Date:   2019/6/3 17:03
 * Description:
 */

package com.ch.dto;

import java.util.Set;

public class UserDTO {
    private Integer userId;
    private String username;
    private String password;

    private Set<String> roles;

    private Set<String> premissions;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Set<String> getPremissions() {
        return premissions;
    }

    public void setPremissions(Set<String> premissions) {
        this.premissions = premissions;
    }
}
