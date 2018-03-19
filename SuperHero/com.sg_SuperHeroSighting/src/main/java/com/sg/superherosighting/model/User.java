/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.model;

import java.util.ArrayList;

/**
 *
 * @author PG
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int enabled;
    private ArrayList<String> authorities = new ArrayList<>();

    public int getId() {
        return id;
    }

    public int getEnabled(){
        return enabled;
    }
    public void setEnabled(int enabled){
        this.enabled = enabled;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(ArrayList<String> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(String authority) {
        authorities.add(authority);
    }
}
