package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    //查询所有
    public List<Permission> findAll() throws Exception;
}
