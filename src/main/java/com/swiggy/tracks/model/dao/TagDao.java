package com.swiggy.tracks.model.dao;

import com.swiggy.tracks.config.DBConfig;
import com.swiggy.tracks.model.entity.Tag;
import com.swiggy.tracks.util.UUIDUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class TagDao {

    private static final Logger logger = LogManager.getLogger(TagDao.class);

    public boolean add(Tag tag) {
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("insert into tag_ " +
                    "(uid,name,song_count,status) values(?, ?, ?, ?)");
            pst.setBytes(1, UUIDUtility.toBytes(tag.getUid()));
            pst.setString(2, tag.getName());
            pst.setLong(3, tag.getSongCount());
            pst.setBoolean(4, tag.isStatus());
            return pst.executeUpdate() == 1;
        } catch(Exception e) {
            logger.info("exception occurred while inserting user {}");
            e.printStackTrace();
        }
        return false;
    }

    public Tag getTagById(long id) {
        Tag tag = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from tag_ " +
                    "where id = ?");
            pst.setLong(1, id);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                tag = new Tag.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .songCount(rst.getLong("song_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        }catch(Exception e){
            logger.info("exception occurred while fetching user {}");
            e.printStackTrace();
        }
        return tag;
    }

    public Tag getTagByUid(UUID uid) {
        Tag tag = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from tag_ " +
                    "where uid = ?");
            pst.setBytes(1, UUIDUtility.toBytes(uid));
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                tag = new Tag.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .songCount(rst.getLong("song_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        }catch(Exception e){
            logger.info("exception occurred while fetching user {}");
            e.printStackTrace();
        }
        return tag;
    }

    public Tag getTagByName(String name) {
        Tag tag = null;
        try{
            PreparedStatement pst = DBConfig.getConn().prepareStatement("select * from tag_ " +
                    "where name like ?");
            pst.setString(1, name);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                tag = new Tag.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .songCount(rst.getLong("song_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build();
            }
        }catch(Exception e){
            logger.info("exception occurred while fetching user {}");
            e.printStackTrace();
        }
        return tag;
    }

    public List<Tag> getTagByNames(List<String> names) {
        List<Tag> tags = new ArrayList<>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("select * from tag_ where" );
            int length = names.size();
            for(String s : names) {
                length--;
                sql.append(" name like ?");
                if(length != 0) {
                    sql.append(" or");
                }
            }
            PreparedStatement pst = DBConfig.getConn().prepareStatement(sql.toString());
            int ind = 1;
            for(String s : names) {
                pst.setString(ind, s);
                ind++;
            }
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                tags.add(new Tag.Builder().id(rst.getLong("id"))
                        .uid(UUIDUtility.fromBytes(rst.getBytes("uid")))
                        .name(rst.getString("name"))
                        .songCount(rst.getLong("song_count"))
                        .status(rst.getBoolean("status"))
                        .creationTime(rst.getTimestamp("creation_time").toLocalDateTime())
                        .build());
            }
        }catch(Exception e){
            logger.info("exception occurred while fetching user {}");
            e.printStackTrace();
        }
        return tags;
    }
}
