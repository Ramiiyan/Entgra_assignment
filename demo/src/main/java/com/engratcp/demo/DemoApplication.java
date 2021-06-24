package com.engratcp.demo;

import com.engratcp.demo.Service.EntgraTcpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		EntgraTcpServer srv = new EntgraTcpServer();
		srv.run();

	}

}
