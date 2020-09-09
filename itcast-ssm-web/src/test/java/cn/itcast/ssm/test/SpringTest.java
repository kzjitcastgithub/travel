package cn.itcast.ssm.test;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.dao.UserInfoDao;
import cn.itcast.ssm.domain.*;
import cn.itcast.ssm.service.*;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    UserService userService;

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoleService roleService;

    @Autowired
    SysLogService sysLogService;

    @Test
    public void test01() throws Exception{
        List<Product> products = productService.findAll();
        for (Product product:products){
            System.out.println(product);
        }
    }


    @Test
    public void test02(){
        for(int i=0; i<10; i++){
            String string = UUID.randomUUID().toString().replace("-","");
            System.out.println(string);
        }
    }

    @Test
    public void test03() throws Exception{
        Product product = new Product();
        product.setId(UUID.randomUUID().toString().replace("-",""));
        product.setCityName("深圳");
        product.setDepartureTime(new Date());
        product.setProductDesc("深圳欢迎你");
        product.setProductName("深圳一日游");
        product.setProductNum("itcast-005");
        product.setProductStatus(1);
        product.setProductPrice(1990.0);
        product.setDepartureTime(new Date());
        productService.save(product);
    }

    @Test
    public void test04() throws Exception{
        String[] array = {"9F71F01CB448476DAFB309AA6DF9497F"};
        int i = productService.deleteByIds(array);
        System.out.println("-------------->"+i);
    }


    @Test
    public void test05() throws Exception{
        Product product = new Product();
        product.setId("f6e227a5444b45e19a37df85395071e1");
        product.setProductNum("itcast-06");
        product.setProductPrice(10999.0);
        product.setProductStatus(0);
        product.setCityName("上饶");
        productService.update(product);
    }

    @Test
    public void test06() throws Exception{
        List<Product> products = productService.findPageable(2, 3);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        System.out.println(pageInfo);
    }

    @Test
    public void test07() throws Exception{
        List<Orders> ordersList = ordersService.findAll();
        for(Orders orders:ordersList){
            System.out.println(orders);
        }
    }

    @Test
    public void test08() throws Exception{
        Orders orders = ordersService.findById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(orders);
    }

    @Test
    public void test09() throws Exception{
        UserInfo userInfo = userInfoDao.findByName("user");
        System.out.println(userInfo);
        System.out.println("");
    }


    @Test
    public void test10() throws Exception{
        UserDetails user = userService.loadUserByUsername("user");
        System.out.println(user);
    }

    @Test
    public void test11() throws Exception{
        List<UserInfo> userInfoList = userService.findAll();

        System.out.println(userInfoList);
    }

    @Test
    public void test12() throws Exception{
        UserInfo userInfo = userService.findById("40087a25b1cf4b72a29b34319b53bb72");
        System.out.println(userInfo);
    }

    @Test
    public void test13() throws Exception{
        List<Role> roles = userService.findByOtherRolesById("40087a25b1cf4b72a29b34319b53bb72");
        System.out.println(roles);
    }

    @Test
    public void test14() throws Exception{
        List<UserRole> userInfoList = new ArrayList<>();
        userInfoList.add(new UserRole("40087a25b1cf4b72a29b34319b53bb72","10488cba1a2f4e03a5175409d0936b02"));
        userInfoList.add(new UserRole("40087a25b1cf4b72a29b34319b53bb72","aec3667886f244bf85a397366ddc21d3"));
        userService.insertUserRole(userInfoList);
    }

    @Test
    public void test15() throws Exception{
        List<Permission> permissionList = roleService.findOtherPermissionsById("10488cba1a2f4e03a5175409d0936b02");
        System.out.println(permissionList);
    }

    @Test
    public void test16() throws Exception{
        List<Permission> permissions = roleDao.findPermissionsById("10488cba1a2f4e03a5175409d0936b02");
        System.out.println(permissions);
    }

    @Test
    public void test17() throws Exception{
        List<SysLog> sysLogList = sysLogService.findAll();
        System.out.println(sysLogList);
    }

    @Test
    public void test18() throws Exception{
        SysLog sysLog = new SysLog();
        sysLog.setUsername("admin");
        sysLog.setUrl("localhost");
        sysLog.setVisitTime(new Date().toString());
        sysLogService.insertSysLog(sysLog);
    }

    @Test
    public void test19() throws Exception {
        List<Product> productList = productService.findPageable02(0, 5, null);
        System.out.println(productList);
    }

    @Test
    public void test20() throws Exception{
        List<UserInfo> userInfoList = userService.findPageable(1, 2);
        System.out.println(userInfoList);
    }

    @Test
    public void test21() throws Exception {
        List<Orders> orderLists = ordersService.findPageable02(1, 2, "");
        System.out.println(orderLists);
    }
}
