package projeect.springboot.CloudVendorAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CloudVendorApiApplication {

	@GetMapping("/sample")
	public String sample(){
		return "Hello API";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudVendorApiApplication.class, args);
	}

}
