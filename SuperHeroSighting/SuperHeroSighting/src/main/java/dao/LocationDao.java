/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Location;
import model.Member;
import model.Organizations;
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
    
    //methods for Members table
    public void addMember(Member member);//1
    public void deleteMember(int memberID);//2
    public void updateMember(Member memberID);//3
    public Member getMemberByID(int memberID);//4
    public  List<Member> getAllMembers();//5
    public List<Member> getMembersByOrganization();//6
    
    //methods for Organization table
    public void addOrganization(Organizations organization);//1
    public void deleteOrganization(int organizationID);//2
    public void updateOrganization(Organizations organization);//3
    public Organizations getOrganizationByID(int organizationID);//4
    public List<Organizations> getAllOrganizations();//5
    public List<Organizations> getOrganizationsByHero(int heroID);//6    
    
    //methods for Hero table
    public void addHero(SuperHero hero, int organizationID);
    public void deleteHero(int heroID);
    public void updateHero(SuperHero hero);
    public SuperHero getHeroById(int heroID);
    public List<SuperHero> getAllHeros();
    public SuperHero getHeroByLocation(int heroID);
    public List<SuperHero> getHeroByDate(String date);
    public List<SuperHero> getHeroLocationByDate(String Date);
    
    //methods for zipcode Table
    public void addZipCode(ZipCodeInfo zipCode);//1
    //public void deleteZipCode(int zipCode);//2
    public void updateZipCode(ZipCodeInfo zipCode);//3
    public ZipCodeInfo getZipCodeByID(String zipCode);//4
    public List<ZipCodeInfo> getAllZipCodes();    //5
    
}
