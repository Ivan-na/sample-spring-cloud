package ig.fenbeitong.com.openapiauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class OpenapiAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenapiAuthApplication.class, args);
    }


    /**
     * @return java.security.Principal
     * @Author ivan
     * @Description Get Principal user
     * @Date 下午7:24 18-11-5
     * @Param [user]
     **/
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
