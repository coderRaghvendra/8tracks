package com.swiggy.tracks.model.entity;

import java.util.Comparator;

/**
 * Created by raghvendra.mishra on 11/03/20.
 */
public class SongComparator implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        if(o1.getPlayCount() != o2.getPlayCount()) {
            return o1.getPlayCount() < o2.getPlayCount() ? 1 : -1;
        }
        return o1.getLikeCount() == o2.getLikeCount() ? 0 : (o1.getLikeCount() < o2.getLikeCount() ? 1 : -1);
    }
}
