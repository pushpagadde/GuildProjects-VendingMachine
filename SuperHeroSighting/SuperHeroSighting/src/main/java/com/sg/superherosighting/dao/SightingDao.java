/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.model.Location;
import com.sg.superherosighting.model.Sighting;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PG
 */
public interface SightingDao {
    
    //methods for sighting Table
    
    public void addSighting(Sighting sighting, int locationID);//1
    public void deleteSighting(int sightingID);//2
    public List<Sighting> getAllSightings();//3
    public Sighting getSightingByID(int sightingID);//4
    public void updateSighting(int heroID,int locationID,Date dateOfSighting, int sightingID);//5
    public List<Sighting> getAllTopSightings();//6
}
