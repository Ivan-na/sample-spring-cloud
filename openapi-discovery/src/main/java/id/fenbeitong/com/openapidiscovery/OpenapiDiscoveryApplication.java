package id.fenbeitong.com.openapidiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName OpenapiDiscoveryApplication
 * @Description Discovery Service with Eureka
 * @Version 1.0
 * Created by ivan on 上午11:49 18-11-5.
 **/
@SpringBootApplication
@EnableEurekaServer
public class OpenapiDiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenapiDiscoveryApplication.class, args);
    }
}
