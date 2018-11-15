package id.fenbeitong.com.openapiapproveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"id.fenbeitong.com.openapiapproveservice.feign"})
public class OpenapiApproveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenapiApproveServiceApplication.class, args);
    }
}
