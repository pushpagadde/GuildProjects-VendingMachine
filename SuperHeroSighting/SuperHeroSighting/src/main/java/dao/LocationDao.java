/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Location;
import model.Member;
import model.Organization;
import model.SuperHero;
import model.ZipCodeInfo;

/**
 *
 * @author PG
 */
public interface LocationDao {
    //methods for Locations table
    public void addLocation(Location locationID);//1
    public void deleteLocation(int locationID);//2
    public void updateLocation(Location locationID);//3
    public Location getLocationByID(int locationID);//4
    public List<Location> getAllLocations();//5
    public List<Location> getLocationsByHero(int heroID);//6        

}
