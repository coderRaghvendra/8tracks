package com.swiggy.tracks.response;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class ResponseFactory {

    public static Response getErrorResponse() {
        return new BasicResponse.Builder().success(false).build();
    }
}
