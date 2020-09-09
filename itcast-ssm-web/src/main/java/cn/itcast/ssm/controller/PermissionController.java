package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/findPageable.action")
    public ModelAndView findPageable(@RequestParam(value = "page",required = true) Integer page,
                                     @RequestParam(value = "size",required = true) Integer size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findPageable(page,size);
        PageInfo<Permission> pageInfo = new PageInfo<>(permissionList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

}
