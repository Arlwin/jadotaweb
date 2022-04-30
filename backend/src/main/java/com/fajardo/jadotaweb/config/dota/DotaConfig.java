package com.fajardo.jadotaweb.config.dota;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotaConfig {
    
    @Value("${url.opendota}")
    public String openDotaUrl;
    
    @Bean("openDotaUrl")
    public String getOpenDotaUrl(){
        return openDotaUrl;
    }
}
