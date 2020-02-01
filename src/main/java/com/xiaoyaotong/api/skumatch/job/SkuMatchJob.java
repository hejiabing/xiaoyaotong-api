package com.xiaoyaotong.api.skumatch.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import com.xiaoyaotong.api.skumatch.service.SkuMatchService;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2020/2/1 1:49 PM
 */
public class SkuMatchJob implements Job {
    private static Log log = LogFactory.getLog(SkuMatchJob.class);

    @Autowired
    private SkuMatchService skuMatchService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        skuMatchService.matchSku();

    }
}
