package id.fenbeitong.com.openapigateway;

import org.apache.logging.log4j.core.appender.routing.Routes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@SpringBootApplication
@EnableDiscoveryClient
public class OpenapiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenapiGatewayApplication.class, args);
    }
}
