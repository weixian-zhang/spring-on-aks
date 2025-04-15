package spring.aks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class OrderController {

	private final AppConfig appConfig;

	//appconfig is auto injected
	public OrderController(AppConfig appConfig) {
		this.appConfig = appConfig;
	}

	// @Autowired
	// private DiscoveryClient discoveryClient;

	// @Autowired
	// private RestTemplate restTemplate;

	// @Autowired
	// private LoadBalancerClient loadBalancerClient;

	@Autowired
    private EurekaClient eurekaClient;

	@GetMapping("/order")
	public String order(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println("Eureka host = " + appConfig.getEurekaHost());

		//discoveryClient.getInstances(name)
		return  "order received";
	}

	@GetMapping("/order/warehouse")
	public String order() {

		Application application = eurekaClient.getApplication("warehouse-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
		

		RestTemplate restTemplate = new RestTemplate();
        String warehouseServiceUrl = "http://" + hostname + ":" + port + "/warehouse";
        ResponseEntity<String> response = restTemplate.getForEntity(warehouseServiceUrl, String.class);
 
        return response.getBody();
    }
 
}
