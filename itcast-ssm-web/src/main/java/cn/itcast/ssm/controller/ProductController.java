package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.domain.ProductExt;
import cn.itcast.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() throws Exception{
        List<Product> productList = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save.action")
    public String save(ProductExt productExt)throws Exception{
        System.out.println(productExt);
        productService.save(productExt.getProduct());
        return "redirect:findPageable.action?page=1&size=5&context=";
    }

    @RequestMapping("/deleteByIds.action")
    @ResponseBody
    public Map<String,Object> deleteByIds(@RequestParam("ids") String[] ids)throws Exception{
        Map<String,Object> result = new HashMap<>();
        System.out.println("ids:"+ids);
        int i = productService.deleteByIds(ids);
        if(i>0){
            result.put("flag",true);
            result.put("message","删除成功");
        }else{
            result.put("flag",false);
            result.put("message","删除失败");
        }
        return result;
    }

    @RequestMapping("/findById.action")
    @ResponseBody
    public ModelAndView findById(@RequestParam("id") String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);

        System.out.println(product);
        modelAndView.addObject("product",product);
        modelAndView.setViewName("product-edit");
        return modelAndView;
    }

    @RequestMapping("/update.action")
    public String update(Product product) throws Exception{

        System.out.println(product);
        productService.update(product);
        return "redirect:findPageable.action?page=1&size=5&context=";
    }

    @RequestMapping("/findPageable.action")
    public ModelAndView findPageable(@RequestParam(value = "page",required = true) Integer page,
                                     @RequestParam(value = "size",required = true) Integer size,
                                     @RequestParam(value = "context",required = false) String context) throws Exception{
        //List<Product> products = productService.findPageable(page, size);
        if (context == null){
            context = "";
        }
        List<Product> products = productService.findPageable02(page, size,context);
        PageInfo<Product> pageInfo = new PageInfo<Product>(products);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-page-list");
        return modelAndView;
    }

}
