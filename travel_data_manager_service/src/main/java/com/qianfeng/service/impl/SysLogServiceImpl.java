package com.qianfeng.service.impl;

import com.qianfeng.dao.ISysLogDao;
import com.qianfeng.domain.SysLog;
import com.qianfeng.service.ISysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/10 21:32
 * 描述：TODO
 */
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Resource
    ISysLogDao iSysLogDao;

    @Override
    public void addSysLog(SysLog sysLog) {
        iSysLogDao.addSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return iSysLogDao.findAll();
    }
}
