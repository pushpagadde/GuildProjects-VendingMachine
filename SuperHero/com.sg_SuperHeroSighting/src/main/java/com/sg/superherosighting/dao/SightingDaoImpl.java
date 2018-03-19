/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.model.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class SightingDaoImpl implements SightingDao { 
    private JdbcTemplate jdbcTemplate;
    private LocationDao location;// = new LocationDaoImpl();
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SightingDaoImpl(JdbcTemplate jdbcTemplate, LocationDao location) {
        this.jdbcTemplate = jdbcTemplate;
        this.location = location;
    }
    
    private static final String SQL_INSERT_SIGHTING//1
        = "insert into sightings (heroid, locationid, dateofsighting) values (?, ?, ?)";

    private static final String SQL_DELETE_SIGHTING//2
        = "delete from sightings where sightingid = ?";

    private static final String SQL_UPDATE_SIGHTING//3
        = "update sightings set dateofsighting = ?, heroId = ?, locationID = ? where sightingid = ?";

    private static final String SQL_SELECT_SIGHTING//4
        = "select * from sightings where sightingid = ?";
    
    private static final String SQL_SELECT_ALL_SIGHTING//5
        = "select * from sightings";

    private static final String SQL_SELECT_TEN_SIGHTINGS ="select * from sightings order by dateofsighting desc limit 10 ";
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting, int locationID){//1
        
        jdbcTemplate.update(SQL_INSERT_SIGHTING, sighting.getHeroID(), locationID, sighting.getDateOfSighting().toString());            
        int sightingID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);                
        sighting.setSightingID(sightingID);                
    }
    @Override
    public List<Sighting> getAllTopSightings(){
        return jdbcTemplate.query(SQL_SELECT_TEN_SIGHTINGS, new SightingMapper());
    }
    
    @Override
    public void deleteSighting(int sightingID){//2
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingID);    
    }
    @Override
    public List<Sighting> getAllSightings(){//3
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTING, new SightingMapper());
    }
    @Override
    public Sighting getSightingByID(int sightingID){//4
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING, new SightingMapper(), sightingID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public void updateSighting(LocalDate dateOfSighting, int sightingID, int heroID, int locationID){//5
        jdbcTemplate.update(SQL_UPDATE_SIGHTING, dateOfSighting.toString(), heroID, locationID, sightingID);
    }
    
    private static final class SightingMapper implements RowMapper<Sighting> {
        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting s = new Sighting();
            s.setSightingID(rs.getInt("sightingID"));
            s.setHeroID(rs.getInt("heroID"));
            s.setLocationID(rs.getInt("locationID"));
            s.setDateOfSighting(LocalDate.parse(rs.getDate("dateOfSighting").toString()));
            return s;
        }
    }        
}
