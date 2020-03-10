package com.swiggy.tracks.response;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public abstract class AbstractResponseDto implements ResponseDto {
    protected boolean success;

    protected AbstractResponseDto() {}

    protected AbstractResponseDto(AbstractResponseDto.Builder<?, ?> b) {
        success = b.success;
    }

    public abstract static class Builder<R extends AbstractResponseDto, B extends Builder<R, B>> {
        private boolean success;

        public Builder() {}

        public B success(boolean success) {
            this.success = success;
            return self();
        }

        public abstract B self();

        public abstract R build();
    }

    public boolean isSuccess() {
        return this.success;
    }
}
