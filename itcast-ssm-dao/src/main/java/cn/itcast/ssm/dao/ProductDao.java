package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    //查询所有产品信息
    public List<Product> findAll() throws Exception;

    //根据产品名查询
    public List<Product> findByProductName(String productName) throws Exception;

    //保存信息
    public void save(Product product) throws Exception;

    //删除
    public int deleteByIds(String[] ids)throws Exception;

    //根据id查询
    public Product findById(String id)throws Exception;

    //修改页面
    public void update(Product product)throws Exception;

}
