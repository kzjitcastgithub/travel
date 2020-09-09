package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> productList = productDao.findAll();
        return productList;
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
        //int i = 1/0;
    }

    @Override
    public int deleteByIds(String[] ids) throws Exception{
        int i = productDao.deleteByIds(ids);
        return i;
    }

    @Override
    public Product findById(String id) throws Exception {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) throws Exception {
        productDao.update(product);
    }

    @Override
    public List<Product> findPageable(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        List<Product> productList = productDao.findAll();
        return productList;
    }

    @Override
    public List<Product> findPageable02(Integer page, Integer size, String productName) throws Exception {
        PageHelper.startPage(page,size);
        List<Product> productList = productDao.findByProductName(productName);
        return productList;
    }


}
