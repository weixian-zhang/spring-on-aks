package spring.aks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ConfigurationProperties(prefix = "app.config")
public class AppConfig
{
    @Value("${app.config.eurekaHost}")
    private String eurekaHost;
    @Value("${app.config.eurekaPort}")
    private String eurekaPort;

    public String getEurekaHost() {
        return eurekaHost;
    }

    public String getEurekaPort() {
        return eurekaPort;
    }

}