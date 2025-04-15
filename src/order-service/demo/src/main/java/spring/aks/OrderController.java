package spring.aks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private DiscoveryClient discoveryClient;

	@GetMapping("/order")
	public String order(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println("Eureka host = " + appConfig.getEurekaHost());

		//discoveryClient.getInstances(name)
		return  "order received";
	}
}