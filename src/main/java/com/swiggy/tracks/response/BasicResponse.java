package com.swiggy.tracks.response;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public class BasicResponse extends AbstractResponse {

    private BasicResponse(Builder b) {
        super(b);
    }

    public static class Builder extends AbstractResponse.Builder<BasicResponse, Builder> {
        public Builder() {
        }

        public Builder self() {
            return this;
        }

        public BasicResponse build() {
            return new BasicResponse(this);
        }
    }
}
