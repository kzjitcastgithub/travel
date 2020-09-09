package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.RolePermission;
import cn.itcast.ssm.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/findPageable.action")
    public ModelAndView findPageable(@RequestParam(value = "page",required = true) Integer page,
                                     @RequestParam(value = "size",required = true) Integer size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findPageable(page,size);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/findOtherPermissionsById.action")
    public ModelAndView findOtherPermissionsById(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = roleService.findOtherPermissionsById(roleId);
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.addObject("roleId",roleId);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/insertRolePermission.action")
    public String insertRolePermission(@RequestParam(name = "roleId",required = true) String roleId,
                                       @RequestParam(value = "ids",required = true) String[] permissionIds) throws Exception{
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for(int i=0; i<permissionIds.length; i++){
            RolePermission rolePermission = new RolePermission(roleId,permissionIds[i]);
            rolePermissionList.add(rolePermission);
        }
        roleService.insertRolePermission(rolePermissionList);
        return "redirect:findPageable.action?page=1&size=5";
    }
}
