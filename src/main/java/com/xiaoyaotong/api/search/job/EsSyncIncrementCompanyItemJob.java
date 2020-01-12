package com.xiaoyaotong.api.search.job;

import com.xiaoyaotong.api.search.service.EsCompanyItemSynService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 8:55 PM
 */
public class EsSyncIncrementCompanyItemJob implements Job {
    private static Log log = LogFactory.getLog(EsSyncIncrementCompanyItemJob.class);
    @Autowired
    EsCompanyItemSynService esCompanyItemSynService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("EsSyncIncrementCompanyItemJob");
        esCompanyItemSynService.synIncrementCompanyItem();
    }
}
