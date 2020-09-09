package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.domain.UserRole;
import cn.itcast.ssm.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/save.action")
    public String add(@RequestParam(value = "username",required = true)String username,
                      @RequestParam(value = "password",required = true)String password,
                      @RequestParam(value = "email",required = false)String email,
                      @RequestParam(value = "phoneNum",required = false)String phoneNum,
                      @RequestParam(value = "status",required = true)String statusStr){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setEmail(email);
        userInfo.setPhoneNum(phoneNum);
        userInfo.setStatusStr(statusStr);
        userService.saveUserInfo(userInfo);
        System.out.println(userInfo);
        return "redirect:findPageable.action?page=1&size=2";
    }

    @RequestMapping("/userAdd.action")
    public ModelAndView userAdd() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll();
        modelAndView.addObject("userList",userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/findPageable.action")
    public ModelAndView findPageable(@RequestParam(value = "page",required = true) Integer page,
                                     @RequestParam(value = "size",required = true) Integer size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = userService.findPageable(page, size);
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(userInfoList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/findById.action")
    public ModelAndView findById(@RequestParam(value = "id",required = true) String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findByOtherRolesById.action")
    public ModelAndView findByOtherRolesById(@RequestParam(value = "id",required = true) String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = userService.findByOtherRolesById(id);
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("userId",id);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser.action")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,
                                @RequestParam(name = "ids",required = true) String[] ids) throws Exception{
        List<UserRole> userRoleList = new ArrayList<>();
        for(int i=0; i<ids.length; i++){
            userRoleList.add(new UserRole(userId,ids[i]));
        }
        userService.insertUserRole(userRoleList);
        return "redirect:findPageable.action?page=1&size=2";
    }
}
