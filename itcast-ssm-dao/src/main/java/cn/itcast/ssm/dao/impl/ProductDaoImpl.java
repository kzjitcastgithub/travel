package cn.itcast.ssm.dao.impl;

import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public class ProductDaoImpl{

    public List<Product> findAll() throws Exception {
        System.out.println("持久层方法执行了！");
        return null;
    }
}
