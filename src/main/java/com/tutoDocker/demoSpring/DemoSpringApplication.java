package com.tutoDocker.demoSpring;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/client")
	public Client client_id(@RequestParam(value = "id", defaultValue = "101") int id) throws Exception {
		ClientAccess testAccess = new ClientAccess();
		Client client_to_return = testAccess.GET_CLIENT(id);
		return client_to_return;
	}
	
	
	@GetMapping("/clients")
	public ArrayList<Client> all_clients() throws Exception {
		ClientAccess testAccess = new ClientAccess();
		ArrayList<Client> clients_to_return = testAccess.GET_ALL_CLIENT();
		return clients_to_return;
	}
	
	@PostMapping("/add_client")
	public Client newClient(@RequestBody Client newClient) throws Exception {
		ClientAccess testAccess = new ClientAccess();
		testAccess.CREATE_CLIENT(newClient);
		return newClient;
	}
	
	
}
