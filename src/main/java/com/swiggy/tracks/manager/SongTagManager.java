package com.swiggy.tracks.manager;

import com.swiggy.tracks.model.dao.DaoFactory;
import com.swiggy.tracks.model.entity.Song;
import com.swiggy.tracks.model.entity.Tag;

import java.util.List;

/**
 * Created by raghvendra.mishra on 11/03/20.
 */
public class SongTagManager {

    public static List<Tag> getTagsByTagStr(List<String> tagsStr) {
        return DaoFactory.getTagDao().getTagByNames(tagsStr);
    }

    public static List<Song> getSongsByTagIds(List<Long> tagIds) {
        return DaoFactory.getSongDao().getSongsByTagIds(tagIds);
    }
}
