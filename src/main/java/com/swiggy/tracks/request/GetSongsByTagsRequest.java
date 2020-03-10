package com.swiggy.tracks.request;

import com.swiggy.tracks.response.BasicResponse;
import com.swiggy.tracks.response.Response;

import java.util.List;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public class GetSongsByTagsRequest extends AbstractRequest {
    private List<String> tags;

    GetSongsByTagsRequest(Builder b) {
        super(b);
        this.tags = b.tags;
    }

    public static class Builder extends AbstractRequest.Builder<GetSongsByTagsRequest, Builder> {
        private List<String> tags;

        public Builder() {
            super();
        }

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public GetSongsByTagsRequest build() {
            return new GetSongsByTagsRequest(this);
        }
    }

    @Override
    public boolean validate(){
        return super.validate();
    }

    @Override
    public Response process() {
        boolean success = false;
        try {
            return new BasicResponse.Builder().success(success).build();
        } catch (Exception e) {
            return new BasicResponse.Builder().success(false).build();
        }
    }
}
