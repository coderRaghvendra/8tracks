package com.swiggy.tracks.request;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public abstract class AbstractRequest implements Request {

    protected AbstractRequest() {}

    protected AbstractRequest(Builder<?, ?> b) {}

    public static abstract class Builder<R extends AbstractRequest, B extends Builder<R, B>> {

        protected Builder() {}

        protected abstract B self();

        protected abstract R build();
    }

    public boolean validate(){
        return true;
    }
}
