package id.fenbeitong.com.openapijwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * OpenapiJwtApplication
 * <p>Main Runner
 *
 * @author Created by ivan on 下午2:42 18-11-8.
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient

public class OpenapiJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenapiJwtApplication.class, args);
    }
}