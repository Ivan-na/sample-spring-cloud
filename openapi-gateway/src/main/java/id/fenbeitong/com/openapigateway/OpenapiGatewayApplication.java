package id.fenbeitong.com.openapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OpenapiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenapiGatewayApplication.class, args);
    }
}
