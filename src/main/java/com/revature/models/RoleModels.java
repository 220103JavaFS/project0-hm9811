package com.revature.models;

import java.util.Objects;

public class RoleModels {
    private int roleId;
    private String roleName;

    public RoleModels() {
    }

    public RoleModels(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModels that = (RoleModels) o;
        return roleId == that.roleId && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }

    @Override
    public String toString() {
        return "RoleModels{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
