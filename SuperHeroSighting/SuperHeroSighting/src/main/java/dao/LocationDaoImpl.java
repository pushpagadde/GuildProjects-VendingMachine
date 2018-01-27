/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Location;
import model.Member;
import model.Organizations;
import model.SuperHero;
import model.ZipCodeInfo;
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
        = "select h.heroname, l.description, l.ZipCode, zc.City, zc.State" +
        "from sightings as s" +
        "join location as l on s.LocationID = l.LocationID" +
        "join superhero as h on s.HeroId = h.HeroID" +
        "join zipcodeinfo as zc on l.ZipCode = zc.ZipCode" +
        "where h.HeroID = ?";       
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
            location.getDescription(),
            location.getAddress(),
            location.getLatitude(),
            location.getLongitude(),
            location.getZipCode());
        int locationId = 
            jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
    location.setLocationID(locationId);    
    }
    @Override
    public void deleteLocation(int locationID) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationID);
    }
    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getDescription(),
                location.getAddress(),
                location.getLatitude(),
                location.getLatitude(),
                location.getZipCode());
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
    
    private static final String SQL_INSERT_ORGANIZATION//1
    = "insert into organizations (organizationname, address, zipcode, phone)"
       + " values (?, ?, ?, ?)";
    private static final String SQL_DELETE_ORGANIZATION//2
        = "delete from organizations where organizationid = ?";
    private static final String SQL_UPDATE_ORGANIZATION//3
        = "update organizations set organizationname = ?, address = ?, "
        + "zipcode = ?, phone = ? where organizationid =  ?";
    private static final String SQL_SELECT_ORGANIZATION//4
        = "select * from organizations where organizationid = ?";    
    private static final String SQL_SELECT_ALL_ORGANIZATIONS//5
        = "select * from organizations";    
    private static final String SQL_SELECT_ORGANIZATION_BY_HERO//6
        = "select o.organizationname, o.address, o.zipcode, o.phone, zc.city, zc.state" +
        "from organizations as o" +
        "join heroorganization as ho on o.OrganizationID = ho.organizationid" +
        "join zipcodeinfo as zc on o.ZipCode = zc.ZipCode" +
        "where ho.heroid = ?";            
    private static final String SQL_ORGDELETE_ORGMEMBER
        ="delete from organizationmember where organizationid = ? ";
    private static final String SQL_ORGDELETE_HEROORG
        ="delete from heroorganization where organizationid = ?";
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organizations organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getAddress(),
                organization.getZipCode(),
                organization.getPhone());            
    int organizationID = 
            jdbcTemplate.queryForObject("select LAST_INSERT_ID()", 
                                         Integer.class);
    organization.setOrganizationID(organizationID);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteOrganization(int organizationID) {        
        jdbcTemplate.update(SQL_ORGDELETE_ORGMEMBER, organizationID);
        jdbcTemplate.update(SQL_ORGDELETE_HEROORG, organizationID);        
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationID);
    }
    @Override
    public void updateOrganization(Organizations organization) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getAddress(),
                organization.getZipCode(),
                organization.getPhone());
    }
    @Override
    public Organizations getOrganizationByID(int organizationID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, 
                                               new OrganizationsMapper(), 
                                               organizationID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    @Override
    public List<Organizations> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, 
                              new OrganizationsMapper());
    }
    @Override
    public List<Organizations> getOrganizationsByHero(int heroID) {
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATION_BY_HERO, 
                              new OrganizationsMapper());
    }    
    private static final class OrganizationsMapper implements RowMapper<Organizations> {
        @Override
        public Organizations mapRow(ResultSet rs, int i) throws SQLException {
            Organizations o = new Organizations();
            o.setOrganizationName(rs.getString("organizationname"));
            o.setAddress(rs.getString("address"));
            o.setZipCode(rs.getString("zipcode"));
            o.setPhone(rs.getString("phone"));
            o.setOrganizationID(rs.getInt("organizationid"));
            return o;
        }
    }
    
    //member impl methods    
    private static final String SQL_INSERT_MEMBER//1
    = "insert into members (firstname, lastname, address, zipcode)"
       + " values (?, ?, ?, ?)";
    private static final String SQL_DELETE_MEMBER//2
        = "delete from members where memberid = ?";
    private static final String SQL_UPDATE_MEMBER//3
        = "update members set firsname = ?, lastname = ?, address = ?, "
        + "zipcode = ? where locationid =  ?";
    private static final String SQL_SELECT_MEMBER//4
        = "select * from members where memberid = ?";    
    private static final String SQL_SELECT_ALL_MEMBERS//5
        = "select * from members";    
    private static final String SQL_SELECT_MEMBER_BY_ORGANIZATION//6
        = "select m.firstname, m.lastname, m.address, m.zipcode, zc.city, zc.state " +
        "from members as m" +
        "join organizationmember as om on m.memberid = om.MemberID" +
        "join zipcodeinfo as zc on m.ZipCode = zc.ZipCode" +
        "where om.OrganizationID = ?";          
    private static final String SQL_DELETE_ORGMEMBER
            ="delete from organizationmember where memberid = ?";
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addMember(Member member) {
        jdbcTemplate.update(SQL_INSERT_MEMBER,
                member.getFirstName(),
                member.getLastName(),
                member.getAddress(),
                member.getZipCode());
        int memberID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        member.setMemberID(memberID);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteMember(int memberID) {
        jdbcTemplate.update(SQL_DELETE_ORGMEMBER, memberID);
        jdbcTemplate.update(SQL_DELETE_MEMBER, memberID);        
    }
    @Override
    public void updateMember(Member member) {
        jdbcTemplate.update(SQL_UPDATE_MEMBER,
                member.getFirstName(),
                member.getLastName(),
                member.getAddress(),
                member.getZipCode());
    }
    @Override
    public Member getMemberByID(int memberID) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_MEMBER, 
                                           new MemberMapper(),memberID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    @Override
    public List<Member> getAllMembers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_MEMBERS, 
                              new MemberMapper());
    }
    @Override
    public List<Member> getMembersByOrganization() {
        return jdbcTemplate.query(SQL_SELECT_MEMBER_BY_ORGANIZATION, 
                              new MemberMapper());
    }
    private static final class MemberMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int i) throws SQLException {
            Member m = new Member();
            m.setFirstName(rs.getString("firstname"));
            m.setLastName(rs.getString("lastname"));
            m.setAddress(rs.getString("address"));
            m.setZipCode(rs.getString("zipcode"));            
            m.setMemberID(rs.getInt("memberid"));
            return m;
        }
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
        jdbcTemplate.update(SQL_UPDATE_HERO, hero.getHeroName(),hero.getHeroPower());
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
        
    ///zipcode impl methods        
    private static final String SQL_INSERT_ZIPCODE//1
    = "insert into zipcodeinfo (zipcode, city, state)"
       + " values (?, ?, ?)";
    /*private static final String SQL_DELETE_ZIPCODE//2
        = "delete from zipcodeinfo where zipcode = ?";*/
    private static final String SQL_UPDATE_ZIPCODE//3
        = "update zipcodeinfo set zipcode = ?, city = ?, state = ?, where zipcode =  ?";
    private static final String SQL_SELECT_ZIPCODE//4
        = "select * from zipcodeinfo where zipcode = ?";    
    private static final String SQL_SELECT_ALL_ZIPCODE//5
        = "select * from zipcodeinfo";            
    @Override
    public void addZipCode(ZipCodeInfo zipCode) {
        jdbcTemplate.update(SQL_INSERT_ZIPCODE,
                zipCode.getZipCode(),
                zipCode.getCity(),
                zipCode.getState());        
    }
/*    @Override
    public void deleteZipCoe(int zipCode) {
        jdbcTemplate.update(SQL_DELETE_ZIPCODE, zipCode);
    }*/
    @Override
    public void updateZipCode(ZipCodeInfo zipCode) {
        jdbcTemplate.update(SQL_UPDATE_ZIPCODE,
                zipCode.getZipCode(),
                zipCode.getCity(),
                zipCode.getState());
    }
    @Override
    public ZipCodeInfo getZipCodeByID(String zipCode) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ZIPCODE, 
                   new ZipCodeInfoMapper(), zipCode);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    @Override
    public List<ZipCodeInfo> getAllZipCodes() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ZIPCODE, new ZipCodeInfoMapper());
    }
    private static final class ZipCodeInfoMapper implements RowMapper<ZipCodeInfo> {
        @Override
        public ZipCodeInfo mapRow(ResultSet rs, int i) throws SQLException {
            ZipCodeInfo zc = new ZipCodeInfo();
            zc.setZipCode(rs.getString("zipcode"));
            zc.setCity(rs.getString("city"));
            zc.setState(rs.getString("state"));
            return zc;
        }
    }        
}