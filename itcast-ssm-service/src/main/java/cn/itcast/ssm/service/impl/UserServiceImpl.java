package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserInfoDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.domain.UserRole;
import cn.itcast.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoDao userInfoDao;

    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try{
            userInfo = userInfoDao.findByName(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthorities(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoDao.saveUserInfo(userInfo);
    }

    @Override
    public List<UserInfo> findAll() throws Exception {

        return userInfoDao.findAll();
    }

    @Override
    public List<UserInfo> findPageable(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        List<UserInfo> userInfoList = userInfoDao.findAll();
        return userInfoList;
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userInfoDao.findById(id);
    }

    @Override
    public List<Role> findByOtherRolesById(String id) throws Exception {
        return userInfoDao.findByOtherRolesById(id);
    }

    @Override
    public void insertUserRole(List<UserRole> userRoleList) throws Exception {
        userInfoDao.insertUserRole(userRoleList);
    }


}
