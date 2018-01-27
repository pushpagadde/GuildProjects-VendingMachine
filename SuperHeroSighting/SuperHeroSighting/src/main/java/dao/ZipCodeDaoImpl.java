/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.ZipCodeInfo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author PG
 *//*
public class ZipCodeDaoImpl implements ZipCodeDao{
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT_ZIPCODE//1
    = "insert into zipcodeinfo (zipcode, city, state)"
       + " values (?, ?, ?)";

    private static final String SQL_DELETE_ZIPCODE//2
        = "delete from zipcodeinfo where zipcode = ?";

    private static final String SQL_UPDATE_ZIPCODE//3
        = "update zipcodeinfo set zipcode = ?, city = ?, state = ?, where zipcode =  ?";

    private static final String SQL_SELECT_ZIPCODE//4
        = "select * from zipcodeinfo where zipcode = ?";
    
    private static final String SQL_SELECT_ALL_ZIPCODE//5
        = "select * from zipcodeinfo";
        
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addZipCode(ZipCodeInfo zipCode) {
        jdbcTemplate.update(SQL_INSERT_ZIPCODE,
                zipCode.getZipCode(),
                zipCode.getCity(),
                zipCode.getState());
        
    }

    @Override
    public void deleteZipCoe(int zipCode) {
        jdbcTemplate.update(SQL_DELETE_ZIPCODE, zipCode);
    }

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
                                               new ZipCodeInfoMapper(), 
                                               zipCode);
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
    
}*/
