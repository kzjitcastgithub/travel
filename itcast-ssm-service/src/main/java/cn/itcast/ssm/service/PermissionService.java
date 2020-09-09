package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    //查询所有
    public List<Permission> findAll() throws Exception;

    //分页查询
    public List<Permission> findPageable(int page, int size) throws Exception;
}
