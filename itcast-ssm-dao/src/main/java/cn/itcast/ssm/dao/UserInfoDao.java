package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.domain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {

    //添加用户
    public void saveUserInfo(UserInfo userInfo);

    //根据姓名查询
    public UserInfo findByName(String username) throws Exception;

    //根据id查询
    public UserInfo findById(String id) throws Exception;

    //查询所有
    public List<UserInfo> findAll() throws Exception;

    //查询所有未关联的角色信息
    public List<Role> findByOtherRolesById(String id) throws Exception;

    //关联用户角色(该方法需要数据库设置id制动生成的触发器)
    public void insert(@Param("userId") String userId, @Param("rolesId") String[] rolesId) throws Exception;

    //关联用户角色
    public void insertUserRole(@Param("userRoleList") List<UserRole> userRoleList) throws Exception;
}
