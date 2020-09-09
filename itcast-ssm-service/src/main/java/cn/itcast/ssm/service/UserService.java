package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.domain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {

    //添加用户
    public void saveUserInfo(UserInfo userInfo);

    //查询所有
    public List<UserInfo> findAll() throws Exception;

    //分页查询
    public List<UserInfo> findPageable(int page, int size) throws Exception;

    //根据id查询
    public UserInfo findById(String id) throws Exception;

    //查询所有未关联的角色信息
    public List<Role> findByOtherRolesById(String id) throws Exception;

    //关联用户角色
    public void insertUserRole(List<UserRole> userRoleList) throws Exception;

    //关联用户角色
    //public void insert(String userId,String[] rolesId) throws Exception;
}
