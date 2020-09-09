package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.SysLogDao;
import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public List<SysLog> findPageable(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        List<SysLog> sysLogList = sysLogDao.findAll();
        return sysLogList;
    }


    @Override
    public void insertSysLog(SysLog sysLog) throws Exception {
        sysLogDao.insertSysLog(sysLog);
    }
}
