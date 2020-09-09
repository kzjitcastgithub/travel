package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.RolePermission;
import cn.itcast.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceIpml implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public List<Role> findPageable(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public List<Permission> findOtherPermissionsById(String id) throws Exception {
        String[] ids = null;
        List<Permission> permissions = roleDao.findPermissionsById(id);
        if(1 == permissions.size() && null == permissions.get(0) || 0 == permissions.size()){
            permissions.clear();
            Permission permission = new Permission();
            permission.setId("");
            permissions.add(permission);
        }
        List<Permission> permissionList = roleDao.findOtherPermissions(permissions);
        return permissionList;
    }

    @Override
    public void insertRolePermission(List<RolePermission> rolePermissionList) throws Exception {
        roleDao.insertRolePermission(rolePermissionList);
    }
}
