package spring.aks.warehouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {


	@GetMapping("/warehouse")
	public String order(@RequestParam(value = "name", defaultValue = "World") String name) {
		return  "stock deducted";
	}
}