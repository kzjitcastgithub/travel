package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    //查询所有
    public List<Role> findAll() throws Exception;

    //查询所有未关联角色权限
    //public List<Permission> findOtherPermissionsById(String id) throws Exception;
    public List<Permission> findPermissionsById(String id) throws Exception;
    public List<Permission> findOtherPermissions(@Param("permissionList") List<Permission> permissionList) throws Exception;

    //关联角色权限
    public void insertRolePermission(@Param("rolePermissionList") List<RolePermission> rolePermissionList) throws Exception;
}
