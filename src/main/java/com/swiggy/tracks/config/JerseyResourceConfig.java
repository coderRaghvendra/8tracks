package com.swiggy.tracks.config;

import com.swiggy.tracks.resource.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * 
 * @author Raghvendra.Mishra
 *
 */
public class JerseyResourceConfig extends ResourceConfig {
	private static final Logger logger = LogManager.getLogger(JerseyResourceConfig.class);

	public JerseyResourceConfig() {
		logger.info("Configuring ResourceConfig");
		packages(Resource.class.getPackage().getName());
		register(JacksonFeature.class);
		register(MultiPartFeature.class);
//		register(AuthenticationFilter.class);
		logger.info("Configured ResourceConfig");
	}
}
