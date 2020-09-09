package cn.itcast.ssm.test;


import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MybtaisTest {

    @Test
    public void test01() throws Exception{
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        Product product = new Product();
        product.setId(UUID.randomUUID().toString().replace("-",""));
        product.setCityName("深圳");
        product.setDepartureTime(new Date());
        product.setProductDesc("深圳欢迎你");
        product.setProductName("深圳一日游");
        product.setProductNum("itcast-005");
        mapper.save(product);

    }
}
