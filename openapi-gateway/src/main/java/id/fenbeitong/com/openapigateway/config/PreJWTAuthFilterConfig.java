package id.fenbeitong.com.openapigateway.config;

import id.fenbeitong.com.openapigateway.filter.PreJWTAuthGatewayFilter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * PreJWTAuthFilterConfig
 * <p> Config JWT Auth Filter
 *
 * @author Created by ivan on 下午4:47 18-11-8.
 * @version 1.0
 **/
@SpringBootConfiguration
public class PreJWTAuthFilterConfig {

    @Bean
    public PreJWTAuthGatewayFilter preJWTAuthGatewayFilter() {
        return new PreJWTAuthGatewayFilter();
    }
}
