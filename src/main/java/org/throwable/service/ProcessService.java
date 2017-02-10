package org.throwable.service;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.throwable.entity.ReceivableItem;
import org.throwable.support.ItemStepProcessor;

import java.util.Date;

/**
 * @author zhangjinci
 * @version 2017/2/10 18:38
 * @function
 */
@Service
public class ProcessService {

    @Autowired
    private MyBatisPagingItemReader myBatisPagingItemReader;

    @Autowired
    private MyBatisBatchItemWriter myBatisBatchItemWriter;


    @Autowired
    private SimpleJobLauncher simpleJobLauncher;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemProcessor itemProcessortemProcessor;

    public void process() throws Exception {
        Step step = stepBuilderFactory.get("calculateReceivableItemFeeStep1")
                .chunk(1000)
                .reader(myBatisPagingItemReader)
                .faultTolerant()
                .processor(itemProcessortemProcessor)
                .writer(myBatisBatchItemWriter)
                .build();
        Job job = jobBuilderFactory.get("calculateReceivableItemFeeJob1")
                .start(step).build();
        JobParameters parameters = new JobParametersBuilder()
                .addString("runDay", new Date().toString())  //以日期为参数，可保证一天只能执行一次
                .toJobParameters();
        simpleJobLauncher.run(job, parameters);

    }
}
