/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.sg.superherosighting.model.Organization;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class OrganizationDaoImpl implements OrganizationDao{    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_ORGANIZATION//1
    = "insert into organizations (organizationname, address, zipcode, phone)"
       + " values (?, ?, ?, ?)";

    private static final String SQL_DELETE_ORGANIZATION//2
        = "delete from organizations where organizationid = ?";

    private static final String SQL_UPDATE_ORGANIZATION//3
        = "update organizations set organizationname = ?, address = ?, "
        + "zipcode = ?, phone = ? where organizationid = ?";

    private static final String SQL_SELECT_ORGANIZATION//4
        = "select * from organizations where organizationid = ?";
    
    private static final String SQL_SELECT_ALL_ORGANIZATIONS//5
        = "select * from organizations";
    
    private static final String SQL_SELECT_ORGANIZATION_BY_HERO//6
        = "select o.organizationname, o.address, o.zipcode, o.phone, o.OrganizationID " +
        "from organizations as o " +
        "join heroorganization as ho on o.OrganizationID = ho.organizationid " +
        "join zipcodeinfo as zc on o.ZipCode = zc.ZipCode " +
        "where ho.heroid = ?";        

    private static final String SQL_SELECT_ORGANIZATION_NAMES//7
            ="select organizationname from organizations";
    
    private static final String SQL_DELETE_HEROORGDEPENDENCY //8
            ="delete from heroorganization where organizationid = ?";
    
    private static final String SQL_DELETE_ORGMEMBERDEPENDENCY//9
            ="delete from organizationmember where organizationid= ?";
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization organization) {
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
    public void deleteOrganization(int organizationID) {
        jdbcTemplate.update(SQL_DELETE_HEROORGDEPENDENCY,organizationID);
        jdbcTemplate.update(SQL_DELETE_ORGMEMBERDEPENDENCY, organizationID);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationID);
    }

    @Override
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getAddress(),
                organization.getZipCode(),
                organization.getPhone(),
                organization.getOrganizationID());
    }

    @Override
    public Organization getOrganizationByID(int organizationID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, 
                                               new OrganizationsMapper(), 
                                               organizationID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
        }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, 
                              new OrganizationsMapper());
    }

    @Override
    public List<String> getOrganizationNames(){
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATION_NAMES, (RowMapper<String>) new OrganizationNamesMapper());
    }    
    
    @Override
    public List<Organization> getOrganizationsByHero(int heroID) {
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATION_BY_HERO, new OrganizationsMapper(), heroID);
    }
    
    private static final class OrganizationNamesMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("organizationname");
        }
    }        
    private static final class OrganizationsMapper implements RowMapper<Organization> {
        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization o = new Organization();
            o.setOrganizationName(rs.getString("organizationname"));
            o.setAddress(rs.getString("address"));
            o.setZipCode(rs.getString("zipcode"));
            o.setPhone(rs.getString("phone"));
            o.setOrganizationID(rs.getInt("organizationid"));
            return o;
        }
    }    
}
