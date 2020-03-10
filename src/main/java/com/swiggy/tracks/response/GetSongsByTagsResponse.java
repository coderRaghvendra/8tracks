package com.swiggy.tracks.response;

import com.swiggy.tracks.model.entity.Song;

import java.util.List;

/**
 * Created by raghvendra.mishra on 03/03/20.
 */
public class GetSongsByTagsResponse extends AbstractResponseDto {
    private List<Song> songs;

    protected GetSongsByTagsResponse(Builder b) {
        super(b);
        this.songs = b.songs;
    }

    public static class Builder extends AbstractResponseDto.Builder<GetSongsByTagsResponse, Builder> {
        private List<Song> songs;

        public Builder() {}

        public Builder songs(List<Song> songs) {
            this.songs = songs;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public GetSongsByTagsResponse build() {
            return new GetSongsByTagsResponse(this);
        }
    }

    public List<Song> getSongs() {
        return songs;
    }
}
