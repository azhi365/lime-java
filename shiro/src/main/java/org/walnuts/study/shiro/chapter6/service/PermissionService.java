package org.walnuts.study.shiro.chapter6.service;

import org.walnuts.study.shiro.chapter6.entity.Permission;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface PermissionService {
    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);
}
