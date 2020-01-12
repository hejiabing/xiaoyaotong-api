package com.xiaoyaotong.api.search.job;

import com.xiaoyaotong.api.search.service.EsPlatformSkuSynService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/3 10:35 PM
 */
public class EsSyncIncrementSkuJob implements Job {

    private static Log log = LogFactory.getLog(EsSyncIncrementSkuJob.class);


    @Autowired
    EsPlatformSkuSynService esPlatformSkuSynService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("EsSyncIncrementSkuJob");
        esPlatformSkuSynService.synIncrementSku();
    }
}
