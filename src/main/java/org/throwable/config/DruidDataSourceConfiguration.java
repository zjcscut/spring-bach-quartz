package org.throwable.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.throwable.config.prop.DruidDataSourceProp;

import javax.sql.DataSource;

/**
 * @author zhangjinci
 * @version 2017/1/18 14:28
 * @function Druid数据源相关配置
 */
@Configuration
@EnableConfigurationProperties(value = DruidDataSourceProp.class)
public class DruidDataSourceConfiguration {

    private final DruidDataSourceProp druidDataSourceProp;

    public DruidDataSourceConfiguration(DruidDataSourceProp druidDataSourceProp) {
        this.druidDataSourceProp = druidDataSourceProp;
    }

    @Bean(value = "dataSource")
    @ConditionalOnMissingBean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(druidDataSourceProp.getUrl());
        dataSource.setUsername(druidDataSourceProp.getUsername());
        dataSource.setPassword(druidDataSourceProp.getPassword());
        dataSource.setDriverClassName(druidDataSourceProp.getDriverClassName());
        return dataSource;
    }
}
