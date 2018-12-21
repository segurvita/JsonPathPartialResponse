package com.segur.sample;

import org.glassfish.jersey.server.ResourceConfig;

import com.segur.sample.endpoint.JsonPathEndpoint;

public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(JsonPathEndpoint.class);
	}
}
