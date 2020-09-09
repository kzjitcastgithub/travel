package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    SysLogService sysLogService;

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll();
        modelAndView.addObject("sysLogList",sysLogList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

    @RequestMapping("/findPageable.action")
    //@RolesAllowed("ADMIN")
    @Secured("ROLE_ADMIN")
    public ModelAndView findPageable(@RequestParam(value = "page",required = true) Integer page,
                                     @RequestParam(value = "size",required = true) Integer size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findPageable(page,size);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
