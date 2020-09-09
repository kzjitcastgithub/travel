package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() throws Exception{
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ordersList",ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findPageable.action")
    public ModelAndView findPageable(@RequestParam(value = "page",required = true) Integer page,
                                     @RequestParam(value = "size",required = true) Integer size,
                                     @RequestParam(value = "context", required = false) String context) throws Exception{
        if(context == null){
            context = "";
        }
        List<Orders> ordersList = ordersService.findPageable02(page,size,context);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findById.action")
    public ModelAndView findById(@RequestParam(value = "id",required = true) String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
