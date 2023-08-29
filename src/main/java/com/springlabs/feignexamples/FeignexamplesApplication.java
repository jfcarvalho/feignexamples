package com.springlabs.feignexamples;

import com.springlabs.feignexamples.client.UserClient;
import com.springlabs.feignexamples.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableFeignClients
public class FeignexamplesApplication {

	@Autowired
	private UserClient client;

	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUser(){
		return client.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignexamplesApplication.class, args);
	}

}
