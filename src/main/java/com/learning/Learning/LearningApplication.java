package com.learning.Learning;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.controller.Greeting;
import com.learning.hello.Person;


@SpringBootApplication
@ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = Person.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@SuppressWarnings("unused")
@RestController
public class LearningApplication {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "Nama", defaultValue = "Word") String Name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, Name));
	}
	
	

}
