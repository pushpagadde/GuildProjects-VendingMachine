/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.model.User;
import java.util.List;


/**
 *
 * @author PG
 */
public interface UserDao {
    public User addUser(User user);
    public void deleteUser(String username);
    public void editUser(String username, int userstatus);
    public User getUser(String username);
    public List<User> getAllUsers();
    public void addAuthority(String username, String authority);
    public void deleteAuthorities(String username);
}
