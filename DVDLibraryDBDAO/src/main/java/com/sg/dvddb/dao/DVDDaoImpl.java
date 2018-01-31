/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvddb.dao;

import com.sg.dvddb.dao.DVDDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.sg.dvddb.model.DVDInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class DVDDaoImpl implements DVDDao{

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_UPDATE_DVD
        = "update dvdinfo set title = ?, releaseyear = ?, director = ?, "
        + "rating = ?, notes = ? where dvdid =  ?";

    private static final String SQL_SELECT_DVD = "select * from dvdinfo where dvdid = ?";
    private static final String SQL_SELECT_ALL_DVDS = "select * from dvdinfo";
    private static final String SQL_SELECT_DVD_BY_TITLE = "select * from dvdinfo where title = ?";
    private static final String SQL_SELECT_DVD_BY_RELEASEYEAR = "select * from dvdinfo where releaseYear = ?";
    private static final String SQL_SELECT_DVD_BY_DIRECTOR = "select * from dvdinfo where director = ?";
    private static final String SQL_SELECT_DVD_BY_RATING = "select * from dvdinfo where rating = ?";
    private static final String SQL_DELETE_DVD = "delete from dvdinfo where dvdid = ?";
    private static final String SQL_INSERT_DVD = "insert into dvdinfo (title, releaseyear, director, rating, notes) values (?, ?, ?, ?, ?)";
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addDVD(DVDInfo dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
            dvd.getTitle(),
            dvd.getReleaseYear(),
            dvd.getDirector(),
            dvd.getRating(),
            dvd.getNotes());        
        int dvdID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        dvd.setDvdID(dvdID);
    }

    @Override
    public void removeDVD(long dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDVD(DVDInfo dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseYear(),
                dvd.getDirector(),
                dvd.getRating(),
                dvd.getNotes(), dvd.getDvdID());
    }

    @Override
    public DVDInfo getDVDById(int dvdId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DVDInfoMapper(), dvdId);
    }

    
    @Override
    public List<DVDInfo> getAllDVDs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DVDInfoMapper());
    }

    @Override
    public List<DVDInfo> getDVDByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_DVD_BY_TITLE, new DVDInfoMapper(), title);
    }

    @Override
    public List<DVDInfo> getDVDByReleaseDate(String releaseYear) {
        return jdbcTemplate.query(SQL_SELECT_DVD_BY_RELEASEYEAR, new DVDInfoMapper(), releaseYear);
    }

    @Override
    public List<DVDInfo> getDVDByDirector(String director) {
        return jdbcTemplate.query(SQL_SELECT_DVD_BY_DIRECTOR, new DVDInfoMapper(), director);
    }

    @Override
    public List<DVDInfo> getDVDByRating(String rating) {
        return jdbcTemplate.query(SQL_SELECT_DVD_BY_RATING, new DVDInfoMapper(), rating);
    }
    
    private static final class DVDInfoMapper implements RowMapper<DVDInfo> {
        @Override
        public DVDInfo mapRow(ResultSet rs, int i) throws SQLException {
            DVDInfo dvd = new DVDInfo();
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseYear(rs.getString("releaseyear"));
            dvd.setDirector(rs.getString("director"));
            dvd.setRating(rs.getString("rating"));
            dvd.setNotes(rs.getString("notes"));
            dvd.setDvdID(rs.getInt("dvdid"));            
            return dvd;
        }
    }
}
