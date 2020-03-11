package com.swiggy.tracks.model.dao;

import com.swiggy.tracks.config.DBConfig;
import com.swiggy.tracks.model.entity.SongTag;
import com.swiggy.tracks.util.UUIDUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class SongTagDao {

    private static final Logger logger = LogManager.getLogger(SongTagDao.class);

    public boolean add(SongTag songTag) {
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("insert into song_tag " +
                    "(uid,song_id,tag_id,status) values(?, ?, ?, ?)");
            pst.setBytes(1, UUIDUtility.toBytes(songTag.getUid()));
            pst.setLong(2, songTag.getSongId());
            pst.setLong(3, songTag.getTagId());
            pst.setBoolean(4, songTag.isStatus());
            return pst.executeUpdate() == 1;
        } catch(SQLException e) {
            logger.info("SqlException occurred while inserting data", e);
        } catch(Exception e) {
            logger.info("Exception occurred while inserting data", e);
        }
        return false;
    }

    public SongTag getSongTagBySongIdNTagId(long songId, long tagId) {
        SongTag songTag = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from song_tag " +
                    "where song_id = ? and tag_id = ?");
            pst.setLong(1, songId);
            pst.setLong(2, tagId);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                songTag = new SongTag.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .songId(rst.getLong("song_id"))
                        .tagId(rst.getLong("tag_id"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        } catch(SQLException e) {
            logger.info("SqlException occurred while fetching data", e);
        } catch(Exception e) {
            logger.info("Exception occurred while fetching data", e);
        }
        return songTag;
    }

    public SongTag getSongTagByUid(UUID uid) {
        SongTag songTag = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from song_tag " +
                    "where uid = ?");
            pst.setBytes(1, UUIDUtility.toBytes(uid));
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                songTag = new SongTag.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .songId(rst.getLong("song_id"))
                        .tagId(rst.getLong("tag_id"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        } catch(SQLException e) {
            logger.info("SqlException occurred while fetching data", e);
        } catch(Exception e) {
            logger.info("Exception occurred while fetching data", e);
        }
        return songTag;
    }
}
