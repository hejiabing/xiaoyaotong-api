package com.xiaoyaotong.api.search.job;

import com.xiaoyaotong.api.search.service.StandardSpuSynService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/3 10:35 PM
 */
public class ESJobService implements Job {

    @Autowired
    StandardSpuSynService standardSpuSynService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        standardSpuSynService.synStandardSpu();
    }
}
