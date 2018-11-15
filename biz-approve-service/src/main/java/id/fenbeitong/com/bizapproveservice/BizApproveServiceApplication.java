package id.fenbeitong.com.bizapproveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BizApproveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizApproveServiceApplication.class, args);
    }
}
