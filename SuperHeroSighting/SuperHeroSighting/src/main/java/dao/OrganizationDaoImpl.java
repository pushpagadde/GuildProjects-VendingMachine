/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Organizations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 *//*
public class OrganizationDaoImpl implements OrganizationsDao{    
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
    public void deleteOrganization(int organizationID) {
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
}*/
