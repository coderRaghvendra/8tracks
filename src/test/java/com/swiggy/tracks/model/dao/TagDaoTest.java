package com.swiggy.tracks.model.dao;

import com.swiggy.tracks.config.DBConfig;
import com.swiggy.tracks.model.entity.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by raghvendra.mishra on 11/03/20.
 */
public class TagDaoTest {

    private TagDao tagDao;

    @Before // setup()
    public void before() throws Exception {
        System.out.println("Setting it up!");
        DBConfig.initialize();
        tagDao = DaoFactory.getTagDao();
    }

    @After // tearDown()
    public void after() throws Exception {
        System.out.println("Tearing it down");
        DBConfig.closeDB();
        tagDao = null;
    }

    @Test
    public void testAddNGetTag() {
        Tag tag = new Tag.Builder().uid(UUID.randomUUID())
                .name("rock")
                .songCount(0)
                .status(true).build();
        boolean result = tagDao.add(tag);
        assertTrue(result);
        Tag fetchedTag = tagDao.getTagByUid(tag.getUid());
        assertNotNull(fetchedTag);
        assertEquals(tag.getUid(), fetchedTag.getUid());
        assertEquals(tag.getName(), fetchedTag.getName());
        assertEquals(tag.getSongCount(), fetchedTag.getSongCount());
        assertEquals(tag.isStatus(), fetchedTag.isStatus());
    }

    @Test
    public void testGetTagByName() {
        Tag fetchedTag = tagDao.getTagByName("love");
        assertNotNull(fetchedTag);
        assertEquals("love", fetchedTag.getName());
    }

    @Test
    public void testGetTagsByNames() {
        List<String> names = new ArrayList<>();
        names.add("love");
        names.add("indie");
        List<Tag> fetchedTags = tagDao.getTagByNames(names);
        assertNotNull(fetchedTags);
        assertEquals(2, fetchedTags.size());
    }
}
