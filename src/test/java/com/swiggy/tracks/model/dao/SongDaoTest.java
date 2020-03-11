package com.swiggy.tracks.model.dao;

import com.swiggy.tracks.config.DBConfig;
import com.swiggy.tracks.model.entity.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by raghvendra.mishra on 11/03/20.
 */
public class SongDaoTest {

    private SongDao songDao;

    @Before // setup()
    public void before() throws Exception {
        System.out.println("Setting it up!");
        DBConfig.initialize();
        songDao = DaoFactory.getSongDao();
    }

    @After // tearDown()
    public void after() throws Exception {
        System.out.println("Tearing it down");
        DBConfig.closeDB();
        songDao = null;
    }

    @Test
    public void testAddSong() {
        Song song = new Song.Builder().uid(UUID.randomUUID())
                .name("Raabta (Kehte Hain Khuda Ne)")
                .playCount(new Random().nextInt(1000))
                .likeCount(new Random().nextInt(500)).status(true).build();
        boolean result = songDao.add(song);
        assertTrue(result);
        Song fetchedSong = songDao.getSongByUid(song.getUid());
        assertNotNull(fetchedSong);
        assertEquals(song.getUid(), fetchedSong.getUid());
        assertEquals(song.getName(), fetchedSong.getName());
        assertEquals(song.getPlayCount(), fetchedSong.getPlayCount());
        assertEquals(song.getLikeCount(), fetchedSong.getLikeCount());
        assertEquals(song.isStatus(), fetchedSong.isStatus());
    }

    @Test
    public void testGetSongsByTagIds() {
        List<Long> tagIds = new ArrayList<>();
        tagIds.add(1L);
        tagIds.add(2L);
        List<Song> songs = songDao.getSongsByTagIds(tagIds);
        assertEquals(137, songs.size());
    }
}
