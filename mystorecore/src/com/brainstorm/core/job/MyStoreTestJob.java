package com.brainstorm.core.job;

import com.brainstorm.core.model.MyStoreCronjobModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;


public class MyStoreTestJob extends AbstractJobPerformable<MyStoreCronjobModel> {
    public static final Logger log = Logger.getLogger(MyStoreTestJob.class);
    @Override
    public PerformResult perform(MyStoreCronjobModel cronJobModel) {
        for (int i = 0; i < 100 ;i++) {
            try {
                log.info("Greeting from MyStoreTestJob for :" + i + "th  times");
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
