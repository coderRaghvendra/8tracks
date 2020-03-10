package com.swiggy.tracks.model.dao;

/**
 * Created by raghvendra.mishra on 01/03/20.
 */
public class DaoFactory {
    private static SongDao songDao = new SongDao();
    private static TagDao tagDao = new TagDao();
    private static SongTagDao songTagDao = new SongTagDao();

    public static SongDao getSongDao() {
        return songDao;
    }

    public static TagDao getTagDao() {
        return tagDao;
    }

    public static SongTagDao getSongTagDao() {
        return songTagDao;
    }
}
