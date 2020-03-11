package com.swiggy.tracks.model.dao;

import com.swiggy.tracks.config.DBConfig;
import com.swiggy.tracks.model.entity.SongTag;
import com.swiggy.tracks.model.entity.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by raghvendra.mishra on 11/03/20.
 */
public class SongTagDaoTest {

    private SongTagDao songTagDao;

    @Before // setup()
    public void before() throws Exception {
        System.out.println("Setting it up!");
        DBConfig.initialize();
        songTagDao = DaoFactory.getSongTagDao();
    }

    @After // tearDown()
    public void after() throws Exception {
        System.out.println("Tearing it down");
        DBConfig.closeDB();
        songTagDao = null;
    }

    @Test
    public void testAddNGetTag() {
        SongTag songTag = new SongTag.Builder().uid(UUID.randomUUID())
                .songId(1)
                .tagId(1)
                .status(true).build();
        boolean result = songTagDao.add(songTag);
        assertTrue(result);
        SongTag fetchedSongTag = songTagDao.getSongTagByUid(songTag.getUid());
        assertNotNull(fetchedSongTag);
        assertEquals(songTag.getUid(), fetchedSongTag.getUid());
        assertEquals(songTag.getSongId(), fetchedSongTag.getSongId());
        assertEquals(songTag.getTagId(), fetchedSongTag.getTagId());
        assertEquals(songTag.isStatus(), fetchedSongTag.isStatus());
    }
}
