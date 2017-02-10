package org.throwable.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhangjinci
 * @version 2017/2/10 17:03
 * @function
 */
@Configuration
public class BatchProcessorConfiguration {

    @Bean
    public MyBatisPagingItemReader myBatisPagingItemReader(SqlSessionFactory sqlSessionFactory){
        MyBatisPagingItemReader receivableItemReader = new MyBatisPagingItemReader();
        receivableItemReader.setSqlSessionFactory(sqlSessionFactory);
        receivableItemReader.setPageSize(2);
        receivableItemReader.setQueryId("org.throwable.mapper.ReceivableItemMapper.batchProcess");
        return receivableItemReader;
    }

    @Bean
    public MyBatisBatchItemWriter myBatisBatchItemWriter(SqlSessionFactory sqlSessionFactory){
        MyBatisBatchItemWriter writer = new MyBatisBatchItemWriter();
        writer.setSqlSessionFactory(sqlSessionFactory);
        writer.setStatementId("org.throwable.mapper.ReceivableItemMapper.updateSingle");
        return writer;
    }

    @Bean
    public JobRepository jobRepository(PlatformTransactionManager transactionManager,
                                       DataSource dataSource) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("MYSQL");
        jobRepositoryFactoryBean.setDataSource(dataSource);
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher simpleJobLauncher(JobRepository jobRepository) throws Exception {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository);
        return simpleJobLauncher;
    }

    @Bean
    public StepBuilderFactory stepBuilderFactory(JobRepository jobRepository,
                                                 PlatformTransactionManager transactionManager){
        return new StepBuilderFactory(jobRepository,transactionManager);
    }

    @Bean
    public JobBuilderFactory jobBuilderFactory(JobRepository jobRepository){
        return new JobBuilderFactory(jobRepository);
    }
}
