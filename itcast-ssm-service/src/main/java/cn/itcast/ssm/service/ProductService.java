package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    //查询所有产品信息
    public List<Product> findAll() throws Exception;

    //保存信息
    public void save(Product product) throws Exception;

    //删除
    public int deleteByIds(String[] ids) throws Exception;

    //根据id查询
    public Product findById(String id)throws Exception;

    //修改页面
    public void update(Product product)throws Exception;

    //分页查询
    public List<Product> findPageable(Integer page, Integer size) throws Exception;

    public List<Product> findPageable02(Integer page, Integer size, String productName) throws Exception;
}
