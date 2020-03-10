package com.swiggy.tracks.resource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author Raghvendra.Mishra
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateRequest {
	
	ValidationType value();
	
	enum ValidationType {
		IP, AUTH_KEY, ALL
	}
}
