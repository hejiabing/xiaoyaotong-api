package com.xiaoyaotong.api.search.job;

import com.xiaoyaotong.api.search.service.EsSpuSynService;
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
public class EsSyncIncrementSpuJob implements Job {

    private static Log log = LogFactory.getLog(EsSyncIncrementSpuJob.class);

    @Autowired
    EsSpuSynService standardSpuSynService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("EsSyncIncrementSpuJob");
        standardSpuSynService.synIncrementSpu();
    }
}
