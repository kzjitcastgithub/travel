package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    //查询所有
    public List<Role> findAll() throws Exception;
    //分页查询
    public List<Role> findPageable(int page, int size) throws Exception;

    //查询所有未关联角色权限
    public List<Permission> findOtherPermissionsById(String id) throws Exception;

    //关联角色权限
    public void insertRolePermission(@Param("rolePermissionList") List<RolePermission> rolePermissionList) throws Exception;
}
