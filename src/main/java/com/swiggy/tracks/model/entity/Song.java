package com.swiggy.tracks.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class Song {
    private long id;
    private UUID uid;
    private String name;
    private long playCount;
    private long likeCount;
    private boolean status;
    private LocalDateTime creationTime;

    private Song(Builder b) {
        this.id = b.id;
        this.uid = b.uid;
        this.name = b.name;
        this.playCount = b.playCount;
        this.likeCount = b.likeCount;
        this.status = b.status;
        this.creationTime = b.creationTime;
    }

    public static class Builder {
        private long id;
        private UUID uid;
        private String name;
        private long playCount;
        private long likeCount;
        private boolean status;
        private LocalDateTime creationTime;

        public Builder() {}

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder uid(UUID uid) {
            this.uid = uid;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder playCount(long playCount) {
            this.playCount = playCount;
            return this;
        }

        public Builder likeCount(long likeCount) {
            this.likeCount = likeCount;
            return this;
        }

        public Builder status(boolean status) {
            this.status = status;
            return this;
        }

        public Builder creationTime(LocalDateTime creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Song build() {
            return new Song(this);
        }
    }
}
