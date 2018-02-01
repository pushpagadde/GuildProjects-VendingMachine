/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.SuperHero;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class SuperHeroDaoImpl implements SuperHeroDao{
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    //superhero methods
    private static final String SQL_INSERT_HERO//1
    = "insert into superhero (heroname, heropower) values (?, ?)";
    private static final String SQL_DELETE_HERO//2
        = "delete from superhero where heroid = ?";
    private static final String SQL_UPDATE_HERO//3
        = "update superhero set heroname = ?, heropower = ? where heroid =  ?";
    private static final String SQL_SELECT_HERO//4
        = "select * from superhero where heroid = ?";    
    private static final String SQL_SELECT_ALL_HEROS//5
        = "select * from superhero";    
    private static final String SQL_SELECT_HERO_BY_LOCATION//6
        = "select h.heroname, h.heropower" +
        "from superhero as h" +
        "join sightings as s on h.HeroID = s.HeroId" +
        "where s.LocationID = ?";              
    private static final String SQL_SELECT_HERO_BY_DATE//7
        = "select h.heroname, h.heropower" +
        "from superhero as h" +
        "join sightings as s on h.HeroID = s.HeroId" +
        "where s.DateOfSighting = ?";                      
    private static final String SQL_SELECT_HEROLOCATION_BY_DATE//8
        = "select h.heroname, h.heropower, l.description, l.address, l.latitude, l.longitude," +
        "l.zipcode, zc.city, zc.state" +
        "from superhero as h" +
        "join sightings as s on h.HeroID = s.HeroId" +
        "join location as l on l.LocationID = s.LocationID" +
        "join zipcodeinfo as zc on l.ZipCode = zc.ZipCode" +
        "where s.DateOfSighting = ?";             
    private static final String SQL_INSERT_ORGHERO
            ="insert into heroorganization (heroid, organizationid) values (?,?)";
    private static final String SQL_DELETE_HEROORG
        ="delete from heroorganization where heroid = ?";
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHero(SuperHero hero, int organizationID) {
        jdbcTemplate.update(SQL_INSERT_HERO,
            hero.getHeroName(), hero.getHeroPower());
        int heroID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", 
                                         Integer.class);
        jdbcTemplate.update(SQL_INSERT_ORGHERO, heroID , organizationID);        
        hero.setHeroID(heroID);        
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteHero(int heroID) {
        jdbcTemplate.update(SQL_DELETE_HEROORG, heroID);
        jdbcTemplate.update(SQL_DELETE_HERO, heroID);
    }
    @Override
    public void updateHero(SuperHero hero) {
        jdbcTemplate.update(SQL_UPDATE_HERO, hero.getHeroName(),hero.getHeroPower(), hero.getHeroID());
    }
    @Override
    public SuperHero getHeroById(int heroID) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_HERO, 
            new SuperHeroMapper(), heroID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    @Override
    public List<SuperHero> getAllHeros() {
        return jdbcTemplate.query(SQL_SELECT_ALL_HEROS, 
                              new SuperHeroMapper());
    }
    @Override
    public SuperHero getHeroByLocation(int heroID) {
        try {
           return jdbcTemplate.queryForObject(SQL_SELECT_HERO_BY_LOCATION,
                              new SuperHeroMapper(), heroID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }             
    }
    @Override
    public List<SuperHero> getHeroByDate(String date) {
        return jdbcTemplate.query(SQL_SELECT_HERO_BY_DATE, 
                              new SuperHeroMapper());
    }
    @Override
    public List<SuperHero> getHeroLocationByDate(String Date) {
        return jdbcTemplate.query(SQL_SELECT_HEROLOCATION_BY_DATE, 
                              new SuperHeroMapper());        
    }    

    private static final class SuperHeroMapper implements RowMapper<SuperHero> {
        @Override
        public SuperHero mapRow(ResultSet rs, int i) throws SQLException {
            SuperHero sh = new SuperHero();
            sh.setHeroName(rs.getString("heroname"));
            sh.setHeroPower(rs.getString("heropower"));
            sh.setHeroID(rs.getInt("heroID"));
            return sh;
        }
    }
}
