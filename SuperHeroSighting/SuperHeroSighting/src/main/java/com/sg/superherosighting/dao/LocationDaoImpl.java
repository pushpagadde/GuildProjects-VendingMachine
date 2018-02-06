/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.sg.superherosighting.model.Location;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class LocationDaoImpl implements LocationDao{
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_LOCATION//1
    = "insert into location (description, address, latitude, longitude, zipcode)"
       + " values (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_LOCATION//2
        = "delete from location where locationid = ?";
    private static final String SQL_UPDATE_LOCATION//3
        = "update location set description = ?, address = ?, latitude = ?, "
        + "longitude = ?, zipcode = ? where locationid =  ?";
    private static final String SQL_SELECT_LOCATION//4
        = "select * from location where locationid = ?";
    private static final String SQL_SELECT_ALL_LOCATIONS//5
        = "select * from location";  
    private static final String SQL_SELECT_LOCATION_BY_HERO//6
        = "select h.heroname, l.descriptin, l.ZipCode, zc.City, zc.State" +
        "from sightings as s" +
        "join location as l on s.LocationID = l.LocationID" +
        "join superhero as h on s.HeroId = h.HeroID" +
        "join zipcodeinfo as zc on l.ZipCode = zc.ZipCode" +
        "where h.HeroID = ?";       
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION, location.getDescription(), 
            location.getAddress(), location.getLatitude(), 
            location.getLongitude(), location.getZipCode());
        
        int locationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        location.setLocationID(locationId);    
        
    }
    @Override
    public int addSightingLocation(Location location){
        addLocation(location);
        return location.getLocationID();
    }
    
    @Override
    public void deleteLocation(int locationID) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationID);
    }
    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getDescription(), location.getAddress(), location.getLatitude(),
                location.getLongitude(), location.getZipCode(), location.getLocationID());
    }
    @Override
    public Location getLocationByID(int locationID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION, 
                    new LocationMapper(), locationID);
                    
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS, new LocationMapper());
    }
    @Override
    public List<Location> getLocationsByHero(int heroID) {
                return jdbcTemplate.query(SQL_SELECT_LOCATION_BY_HERO, new LocationMapper());
    }    
    private static final class LocationMapper implements RowMapper<Location> {
        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location l = new Location();
            l.setDescription(rs.getString("description"));
            l.setAddress(rs.getString("address"));
            l.setLatitude(rs.getString("latitude"));
            l.setLongitude(rs.getString("longitude"));            
            l.setZipCode(rs.getString("zipcode"));            
            l.setLocationID(rs.getInt("locationid"));
            return l;
        }
    }                 
}