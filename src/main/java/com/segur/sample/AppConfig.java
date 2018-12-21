package com.segur.sample;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	ResourceConfig resourceConfig() {
		return new JerseyConfig();
	}
}
