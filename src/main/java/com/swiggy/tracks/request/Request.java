package com.swiggy.tracks.request;

import com.swiggy.tracks.response.Response;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public interface Request {

    boolean validate();

    Response process();
}
