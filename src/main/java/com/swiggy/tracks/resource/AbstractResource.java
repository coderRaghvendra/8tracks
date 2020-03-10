package com.swiggy.tracks.resource;

import com.swiggy.tracks.request.Request;
import com.swiggy.tracks.response.Response;
import com.swiggy.tracks.response.ResponseFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by raghvendra.mishra on 31/10/18.
 */
public class AbstractResource implements Resource {
    protected static final Logger logger = LogManager.getLogger(AbstractResource.class);

    protected String processRequest(Request request) {
        try {
            if(!request.validate()) {
                logger.warn("Invalid Payload");
                return ResponseFactory.getErrorResponse().toString();
            }
            Response response = request.process();
            logger.info("Response : " + response);
            return response.toString();
        } catch (Exception e) {
            logger.error("Exception : ", e);
            return ResponseFactory.getErrorResponse().toString();
        }
    }
}