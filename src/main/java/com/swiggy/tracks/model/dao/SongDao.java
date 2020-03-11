package com.swiggy.tracks.model.dao;

import com.swiggy.tracks.config.DBConfig;
import com.swiggy.tracks.model.entity.Song;
import com.swiggy.tracks.util.UUIDUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class SongDao {

    private static final Logger logger = LogManager.getLogger(SongDao.class);

    public boolean add(Song song) {
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("insert into song_ " +
                    "(uid,name,play_count,like_count,status) values(?, ?, ?, ?, ?)");
            pst.setBytes(1, UUIDUtility.toBytes(song.getUid()));
            pst.setString(2, song.getName());
            pst.setLong(3, song.getPlayCount());
            pst.setLong(4, song.getLikeCount());
            pst.setBoolean(5, song.isStatus());
            int rowsAffected = pst.executeUpdate();
            return rowsAffected == 1;
        } catch(SQLException e) {
            logger.info("SqlException occurred while inserting data", e);
        } catch(Exception e) {
            logger.info("Exception occurred while inserting data", e);
        }
        return false;
    }

    public Song getSongById(long id) {
        Song song = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from song_ " +
                    "where id = ?");
            pst.setLong(1, id);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                song = new Song.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .playCount(rst.getLong("play_count"))
                        .likeCount(rst.getLong("like_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        } catch(SQLException e) {
            logger.info("SqlException occurred while fetching data", e);
        } catch(Exception e) {
            logger.info("exception occurred while fetching data", e);
        }
        return song;
    }

    public Song getSongByUid(UUID uid) {
        Song song = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from song_ " +
                    "where uid = ?");
            pst.setBytes(1, UUIDUtility.toBytes(uid));
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                song = new Song.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .playCount(rst.getLong("play_count"))
                        .likeCount(rst.getLong("like_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        } catch(SQLException e) {
            logger.info("SqlException occurred while fetching data", e);
        } catch(Exception e) {
            logger.info("exception occurred while fetching data", e);
        }
        return song;
    }

    public List<Song> getSongsByTagIds(List<Long> tagIds) {
        List<Song> songs = new ArrayList<>();
        try{
            StringBuilder sb = new StringBuilder();
            sb.append("select distinct(a.id),a.uid,a.name,a.play_count, a.like_count, a.status, a.creation_time" +
                    " from song_ as a" +
                    " join song_tag as b" +
                    " on a.id = b.song_id" +
                    " where b.tag_id in (");
            int length = tagIds.size();
            for (int i = 0; i < length; i++) {
                sb.append("?");
                if(i < length-1) {
                    sb.append(",");
                }
            }
            sb.append(") and a.status = 1 and b.status = 1 order by play_count desc, like_count desc " +
                    "limit 10");
            PreparedStatement pst = DBConfig.getConn().prepareStatement(sb.toString());
            int ind = 1;
            for(long tagId : tagIds) {
                pst.setLong(ind, tagId);
                ind++;
            }
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                songs.add(new Song.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .playCount(rst.getLong("play_count"))
                        .likeCount(rst.getLong("like_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build());
            }
        } catch(SQLException e) {
            logger.info("SqlException occurred while fetching data", e);
        } catch(Exception e) {
            logger.info("exception occurred while fetching data", e);
        }
        return songs;
    }
}
