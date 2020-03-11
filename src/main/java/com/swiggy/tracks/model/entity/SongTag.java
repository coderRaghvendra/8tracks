package com.swiggy.tracks.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class SongTag {
    private long id;
    private UUID uid;
    private long songId;
    private long tagId;
    private boolean status;
    private LocalDateTime creationTime;

    private SongTag(Builder b) {
        this.id = b.id;
        this.uid = b.uid;
        this.songId = b.songId;
        this.tagId = b.tagId;
        this.status = b.status;
        this.creationTime = b.creationTime;
    }

    public static class Builder {
        private long id;
        private UUID uid;
        private long songId;
        private long tagId;
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

        public Builder songId(long songId) {
            this.songId = songId;
            return this;
        }

        public Builder tagId(long tagId) {
            this.tagId = tagId;
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

        public SongTag build() {
            return new SongTag(this);
        }
    }

    public long getId() {
        return id;
    }

    public UUID getUid() {
        return uid;
    }

    public long getSongId() {
        return songId;
    }

    public long getTagId() {
        return tagId;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
