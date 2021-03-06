/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.SuperHero;

/**
 *
 * @author PG
 */
public interface SuperHeroDao {

    //methods for Hero table
    public void addHero(SuperHero hero, int organizationID);
    public void deleteHero(int heroID);
    public void updateHero(SuperHero hero, int organizationID);
    public SuperHero getHeroById(int heroID);
    public List<SuperHero> getAllHeros();
    public SuperHero getHeroByLocation(int heroID);
    public List<SuperHero> getHeroByDate(String date);
    public List<SuperHero> getHeroLocationByDate(String Date);
        
}
