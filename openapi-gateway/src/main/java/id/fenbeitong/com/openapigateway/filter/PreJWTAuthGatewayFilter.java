package id.fenbeitong.com.openapigateway.filter;

import id.fenbeitong.com.openapicommons.constants.ResponseCode;
import id.fenbeitong.com.openapicommons.dto.ResponseData;
import id.fenbeitong.com.openapicommons.utils.JSONUtils;
import id.fenbeitong.com.openapicommons.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * PreJWTAuthGatewayFilter
 * <p>TODO
 *
 * @author Created by ivan on 下午4:31 18-11-8.
 * @version 1.0
 **/
public class PreJWTAuthGatewayFilter extends AbstractGatewayFilterFactory<PreJWTAuthGatewayFilter.Config> {

    public PreJWTAuthGatewayFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // token in header
            String token = exchange.getRequest().getHeaders().getFirst("Authorization");
            // Response
            ServerHttpResponse response = exchange.getResponse();
            HttpHeaders httpHeaders = response.getHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");

            if (StringUtils.isBlank(token)) {
                String warningStr = JSONUtils.toJson(ResponseData.fail(ResponseCode.NO_AUTH_CODE.getCode(), "Forbidden Access"));
                DataBuffer bodyDataBuffer = response.bufferFactory().wrap(warningStr.getBytes());
                return response.writeWith(Mono.just(bodyDataBuffer));
            } else {
                JWTUtils.JWTResult jwtResult = JWTUtils.getInstance().checkToken(token);
                if (jwtResult.getStatus()) {
                    return chain.filter(exchange);
                } else {
                    String warningStr = JSONUtils.toJson(ResponseData.fail(jwtResult.getCode(), jwtResult.getMsg()));
                    DataBuffer bodyDataBuffer = response.bufferFactory().wrap(warningStr.getBytes());
                    return response.writeWith(Mono.just(bodyDataBuffer));
                }

            }
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
