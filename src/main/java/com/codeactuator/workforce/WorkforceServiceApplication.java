package com.codeactuator.workforce;

import com.codeactuator.rocket.domain.Role;
import com.codeactuator.rocket.domain.Workforce;
import com.codeactuator.workforce.dao.WorkforceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class WorkforceServiceApplication implements ApplicationRunner {

	@Autowired
	private WorkforceRepository workforceRepository;

	public static void main(String[] args) {
		SpringApplication.run(WorkforceServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Hello Workforce!");
	}
}
