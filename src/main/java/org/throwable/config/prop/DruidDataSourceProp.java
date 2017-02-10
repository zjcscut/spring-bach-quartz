package org.throwable.config.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangjinci
 * @version 2017/1/18 14:30
 * @function
 */
@ConfigurationProperties(prefix = DruidDataSourceProp.DRUIDDATASOURCE_PREFIX)
public class DruidDataSourceProp {

    public static final String DRUIDDATASOURCE_PREFIX = "druid";

    private String url;
    private String driverClassName;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
