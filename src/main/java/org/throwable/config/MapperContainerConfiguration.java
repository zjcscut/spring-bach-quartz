package org.throwable.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjinci
 * @version 2017/2/10 16:55
 * @function
 */
@Configuration
public class MapperContainerConfiguration {

    @Bean(value = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("org.throwable.mapper");
        return mapperScannerConfigurer;
    }
}
