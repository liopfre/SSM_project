package com.qianfeng.service;

import com.qianfeng.domain.SysLog;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/10 20:54
 * 描述：TODO
 */
public interface ISysLogService {
    void addSysLog(SysLog sysLog);

    List<SysLog> findAll();
}
