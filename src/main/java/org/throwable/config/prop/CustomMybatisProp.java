package org.throwable.config.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.throwable.utils.ResourceUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/1/18 15:09
 * @function
 */
@ConfigurationProperties(prefix = CustomMybatisProp.CUSTOMMYBATIS_PREFIX)
public class CustomMybatisProp {

    public static final String CUSTOMMYBATIS_PREFIX = "custom-mybatis";

    private String typeAliasesPackages;
    private String[] mappingsLocations;
    private String configurationLocation;

    public String getTypeAliasesPackages() {
        return typeAliasesPackages;
    }

    public String getConfigurationLocation() {
        return configurationLocation;
    }

    public void setConfigurationLocation(String configurationLocation) {
        this.configurationLocation = configurationLocation;
    }

    public void setTypeAliasesPackages(String typeAliasesPackages) {
        this.typeAliasesPackages = typeAliasesPackages;
    }

    public String[] getMappingsLocations() {
        return mappingsLocations;
    }

    public void setMappingsLocations(String[] mappingsLocations) {
        this.mappingsLocations = mappingsLocations;
    }

    public Resource[] resolveMapperLocations() {
        List<Resource> resources = new ArrayList<>();
        if (this.mappingsLocations != null) {
            for (String mapperLocation : this.mappingsLocations) {
                Resource[] mappers = ResourceUtils.getResourcesByPathPattern(mapperLocation);
                resources.addAll(Arrays.asList(mappers));
            }
        }
        return resources.toArray(new Resource[resources.size()]);
    }

    public Resource resolveConfigurationLocation(){
        Resource resource = null;
        if (this.configurationLocation != null){
            resource = ResourceUtils.getResourcesByLocation(configurationLocation);
        }
        return resource;
    }
}
