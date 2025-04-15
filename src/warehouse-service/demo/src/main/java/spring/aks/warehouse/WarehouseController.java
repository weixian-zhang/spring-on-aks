package spring.aks.warehouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

	private final AppConfig appConfig;

	public WarehouseController(AppConfig appConfig) {
		this.appConfig = appConfig;
	}

	@GetMapping("/warehouse")
	public String order(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("eurekaHost: " + appConfig.getEurekaHost());
		return  "stock deducted";
	}
}