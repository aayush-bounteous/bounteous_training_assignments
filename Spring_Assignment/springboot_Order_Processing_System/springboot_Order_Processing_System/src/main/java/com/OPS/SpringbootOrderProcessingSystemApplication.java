package com.OPS;

import com.OPS.model.Order;
import com.OPS.model.OrderEvent;
import com.OPS.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootOrderProcessingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOrderProcessingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(OrderService orderService) {
		return args -> {
			Order order = orderService.createOrder("Test Order");

			orderService.handleEvent(order, OrderEvent.PROCESS);  // NEW -> PROCESSING
			orderService.handleEvent(order, OrderEvent.SHIP);     // PROCESSING -> SHIPPED
			orderService.handleEvent(order, OrderEvent.DELIVER);  // SHIPPED -> DELIVERED
			orderService.handleEvent(order, OrderEvent.CANCEL);   // DELIVERED -> CANCELLED
			orderService.handleEvent(order, OrderEvent.PROCESS);  // Invalid transition
		};
	}

}
