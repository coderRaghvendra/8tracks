package com.swiggy.tracks.response;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public class BasicResponseDto extends AbstractResponseDto {

    private BasicResponseDto(Builder b) {
        super(b);
    }

    public static class Builder extends AbstractResponseDto.Builder<BasicResponseDto, Builder> {
        public Builder() {
        }

        public Builder self() {
            return this;
        }

        public BasicResponseDto build() {
            return new BasicResponseDto(this);
        }
    }
}
