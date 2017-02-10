package org.throwable.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.throwable.config.prop.CustomMybatisProp;

import javax.sql.DataSource;

/**
 * @author zhangjinci
 * @version 2017/1/18 14:55
 * @function
 */
@Configuration
@EnableConfigurationProperties(value = CustomMybatisProp.class)
public class CustomMybatisConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(CustomMybatisConfiguration.class);

    private final CustomMybatisProp customMybatisProp;

    public CustomMybatisConfiguration(CustomMybatisProp customMybatisProp) {
        this.customMybatisProp = customMybatisProp;
    }

    @Bean(value = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setFailFast(true);  //快速失败
            sqlSessionFactoryBean.setTypeAliasesPackage(customMybatisProp.getTypeAliasesPackages());
            if (null != customMybatisProp.getMappingsLocations() && customMybatisProp.getMappingsLocations().length > 0) {
                sqlSessionFactoryBean.setMapperLocations(customMybatisProp.resolveMapperLocations());
            }
            if (null != customMybatisProp.resolveConfigurationLocation()){
                sqlSessionFactoryBean.setConfigLocation(customMybatisProp.resolveConfigurationLocation());
            }

            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("Create mybatis sqlSessionFactory,failed,message:{}", e);
            throw new RuntimeException(e);
        }
    }


    @Bean(value = "transactionManager")
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
