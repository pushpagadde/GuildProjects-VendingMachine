/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Member;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class MemberDaoImpl implements MemberDao{
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //member impl methods    
    private static final String SQL_INSERT_MEMBER//1
    = "insert into members (firstname, lastname, address, zipcode)"
       + " values (?, ?, ?, ?)";
    private static final String SQL_DELETE_MEMBER//2
        = "delete from members where memberid = ?";
    private static final String SQL_UPDATE_MEMBER//3
        = "update members set firstname = ?, lastname = ?, address = ?, "
        + "zipcode = ? where memberid =  ?";
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
                member.getZipCode(),
                member.getMemberID());
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
}