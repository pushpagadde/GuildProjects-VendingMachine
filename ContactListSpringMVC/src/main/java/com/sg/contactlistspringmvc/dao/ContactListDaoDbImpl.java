/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.dao;

import com.sg.contactlistspringmvc.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PG
 */
public class ContactListDaoDbImpl implements ContactListDao{
    
    private static final String SQL_INSERT_CONTACT
            = "insert into contacts "
            + "(first_name, last_name, company, phone, email) "
            + "values (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_CONTACT
            = "delete from contacts where contact_id = ?";
    private static final String SQL_SELECT_CONTACT
            = "select * from contacts where contact_id = ?";
    private static final String SQL_UPDATE_CONTACT
            = "update contacts set "
            + "first_name = ?, last_name = ?, company = ?, "
            + "phone = ?, email = ? "
            + "where contact_id = ?";
    private static final String SQL_SELECT_ALL_CONTACTS
            = "select * from contacts";
    private static final String SQL_SELECT_CONTACTS_BY_LAST_NAME
            = "select * from contacts where last_name = ?";
    private static final String SQL_SELECT_CONTACTS_BY_COMPANY
            = "select * from contacts where company = ?";
    
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Contact addContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT,
            contact.getFirstName(),
            contact.getLastName(),
            contact.getCompany(),
            contact.getPhone(),
            contact.getEmail());

    // query the database for the id that was just assigned to the new
    // row in the database
    int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                                            Integer.class);
    // set the new id value on the contact object and return it
    contact.setContactId(newId);
    return contact;
}

    @Override
    public void removeContact(long contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getContactId());
    }

    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, 
                                  new ContactMapper());
    }

    @Override
    public Contact getContactById(long contactId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT,
                    new ContactMapper(), contactId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just 
            // want to return null in this case
            return null;
        }
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        if (criteria.isEmpty()) {
            return getAllContacts();
        } else {
            StringBuilder sQuery = 
                    new StringBuilder("select * from contacts where ");
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String[numParams];
            Set<SearchTerm> keySet = criteria.keySet();
            Iterator<SearchTerm> iter = keySet.iterator();
            while (iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(),
                    new ContactMapper(),
                    paramVals);
        }
    }

    private static final class ContactMapper implements RowMapper<Contact> {
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getLong("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setCompany(rs.getString("company"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));
            return contact;
        }
    }
}
