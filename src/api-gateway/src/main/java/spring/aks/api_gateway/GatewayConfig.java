package spring.aks.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final AppConfig appConfig;
    
    public GatewayConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        //gateway config tutorial
        //https://medium.com/@gauravraisinghani1998/implementing-spring-cloud-gateway-a-comprehensive-guide-3498aaacfdca

        return builder.routes()
                .route(r -> r.path("/order")
                        .uri(String.format("http://%s:%s", appConfig.getOrderServiceHostname(), appConfig.getOrderServicePort())))

                .route(r -> r.path("/warehouse")
                .uri(String.format("http://%s:%s", appConfig.getWarehouseServiceHostname(), appConfig.getWarehouseServicePort())))
                .build();
    }

}