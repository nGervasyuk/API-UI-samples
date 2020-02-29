package com.samples;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    @DefaultValue("stage")
    @Key("apiPath.${env}")
    String apiPath();
}
