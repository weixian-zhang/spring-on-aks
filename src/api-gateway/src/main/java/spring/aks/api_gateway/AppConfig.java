package spring.aks.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ConfigurationProperties(prefix = "app.config")
public class AppConfig
{
    @Value("${app.config.order_service_hostname}")
    private String order_service_hostname;

    @Value("${app.config.warehouse_service_hostname}")
    private String warehouse_service_hostname;

    @Value("${app.config.order_service_port}")
    private int order_service_port;

    @Value("${app.config.warehouse_service_port}")
    private int warehouse_service_port;

    public String getOrderServiceHostname() {
        return order_service_hostname;
    }

    public String getWarehouseServiceHostname() {
        return warehouse_service_hostname;
    }

    public int getOrderServicePort() {
        return order_service_port;
    }

    public int getWarehouseServicePort() {
        return warehouse_service_port;
    }


}