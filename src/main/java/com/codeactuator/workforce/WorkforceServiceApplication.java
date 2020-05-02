package com.codeactuator.workforce;

import com.codeactuator.workforce.dao.WorkforceRepository;
import com.codeactuator.workforce.domain.Workforce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.metrics.export.datadog.DatadogCounter;
//import org.springframework.metrics.export.datadog.EnableDatadogMetrics;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
//@EnableDatadogMetrics
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

		workforceRepository.saveAll(Arrays.asList(
			new Workforce(null, "Shekhar", "Kumar", "shekhar@gmail.com", "Developer"),
			new Workforce(null, "Hitesh", "Mehta", "hitesh@gmail.com", "Project Manager"),
			new Workforce(null, "Lakhvir", "Bansal", "lakhvir@gmail.com", "Sr. Developer"),
			new Workforce(null, "Sarita", "Gautam", "sarita@gmail.com", "Sr. Developer"),
			new Workforce(null, "Pankaj", "Chauhan", "pankaj@gmail.com", "Sr. Developer"),
			new Workforce(null, "Kruti", "Seth", "kruti@gmail.com", "Tech Lead"),
			new Workforce(null, "Vivekanand", "Sharma", "vivek@gmail.com", "QA"),
			new Workforce(null, "Nidhi", "Mehta", "nidhi@gmail.com", "QA")
		));

		workforceRepository.findAll()
				.forEach(System.out::println);

	}
}
