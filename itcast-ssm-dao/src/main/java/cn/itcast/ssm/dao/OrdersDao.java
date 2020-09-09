package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {

    //查询所有
    public List<Orders> findAll() throws Exception;

    //分页查询
    public List<Orders> findPageable(String context) throws Exception;

    //根据id查询
    public Orders findById(String id) throws Exception;
}
