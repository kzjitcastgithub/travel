package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {

    //查询所有
    public List<Orders> findAll() throws Exception;

    //查询所有
    public List<Orders> findPageable02(int page, int size, String context) throws Exception;

    //根据id查询
    public Orders findById(String id) throws Exception;
}
