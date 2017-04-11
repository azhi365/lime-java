package com.nanoutech.lime.lime.shiro.chapter6.service;

import com.nanoutech.lime.lime.shiro.chapter6.entity.Permission;
import com.nanoutech.lime.lime.shiro.chapter6.dao.PermissionDao;
import com.nanoutech.lime.lime.shiro.chapter6.dao.PermissionDaoImpl;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
