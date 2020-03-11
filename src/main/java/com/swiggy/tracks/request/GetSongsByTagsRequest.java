package com.swiggy.tracks.request;

import com.swiggy.tracks.manager.SongTagManager;
import com.swiggy.tracks.model.entity.Song;
import com.swiggy.tracks.model.entity.SongComparator;
import com.swiggy.tracks.model.entity.SongTag;
import com.swiggy.tracks.model.entity.Tag;
import com.swiggy.tracks.response.BasicResponse;
import com.swiggy.tracks.response.GetSongsByTagsResponse;
import com.swiggy.tracks.response.Response;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Song> songs = new ArrayList<>();
        try {
            List<Tag> tags = SongTagManager.getTagsByTagStr(this.tags);
            if(!tags.isEmpty()) {
                List<Long> tagIds = new ArrayList<>();
                tags.forEach(x -> tagIds.add(x.getId()));
                songs = SongTagManager.getSongsByTagIds(tagIds);

                // sort songs on basis of play count and like count
                Collections.sort(songs, new SongComparator());
                songs = songs.subList(0, 10);
                success = true;
            }
            return new GetSongsByTagsResponse.Builder().songs(songs).success(success).build();
        } catch (Exception e) {
            return new BasicResponse.Builder().success(false).build();
        }
    }
}
