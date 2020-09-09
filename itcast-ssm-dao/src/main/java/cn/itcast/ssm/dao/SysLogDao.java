package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.SysLog;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.List;

@Repository
public interface SysLogDao {

    //查询所有
    public List<SysLog> findAll() throws Exception;

    //插入一条数据
    public void insertSysLog(SysLog sysLog) throws Exception;
}
