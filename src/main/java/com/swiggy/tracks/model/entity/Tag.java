package com.swiggy.tracks.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class Tag {
    private long id;
    private UUID uid;
    private String name;
    private long songCount;
    private boolean status;
    private LocalDateTime creationTime;

    private Tag(Builder b) {
        this.id = b.id;
        this.uid = b.uid;
        this.name = b.name;
        this.songCount = b.songCount;
        this.status = b.status;
        this.creationTime = b.creationTime;
    }

    public static class Builder {
        private long id;
        private UUID uid;
        private String name;
        private long songCount;
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

        public Builder songCount(long songCount) {
            this.songCount = songCount;
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

        public Tag build() {
            return new Tag(this);
        }
    }

    public long getId() {
        return id;
    }

    public UUID getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public long getSongCount() {
        return songCount;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
