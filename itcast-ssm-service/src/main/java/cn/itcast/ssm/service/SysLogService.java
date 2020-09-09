package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.SysLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysLogService {

    //查询所有
    public List<SysLog> findAll() throws Exception;

    //查询分页信息
    public List<SysLog> findPageable(int page, int size) throws Exception;

    //插入一条数据
    public void insertSysLog(SysLog sysLog) throws Exception;
}
