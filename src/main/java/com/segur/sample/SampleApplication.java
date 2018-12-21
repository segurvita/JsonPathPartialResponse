package com.segur.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = { AppConfig.class })
public class SampleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		new SampleApplication().configure(new SpringApplicationBuilder(SampleApplication.class)).run(args);
	}

}
