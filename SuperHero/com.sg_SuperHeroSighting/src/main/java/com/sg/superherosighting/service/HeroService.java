/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.service;

import com.sg.superherosighting.dao.LocationDao;
import com.sg.superherosighting.dao.MemberDao;
import com.sg.superherosighting.dao.OrganizationDao;
import com.sg.superherosighting.dao.SightingDao;
import com.sg.superherosighting.dao.SuperHeroDao;
import com.sg.superherosighting.dao.ZipCodeDao;
import com.sg.superherosighting.model.Location;
import com.sg.superherosighting.model.Member;
import com.sg.superherosighting.model.Organization;
import com.sg.superherosighting.model.Sighting;
import com.sg.superherosighting.model.SuperHero;
import com.sg.superherosighting.model.ZipCodeInfo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PG
 */
public class HeroService {
    LocationDao locationDao;
    MemberDao memberDao;
    OrganizationDao organizationDao;
    SuperHeroDao heroDao;
    ZipCodeDao zipCodeDao;
    SightingDao sightingDao;
    
    HeroService(LocationDao lDao, MemberDao mDao, OrganizationDao oDao, SuperHeroDao sdao, SightingDao sDao, ZipCodeDao zDao){
        this.locationDao = lDao;
        this.memberDao = mDao;
        this.organizationDao = oDao;
        this.heroDao = sdao;
        this.sightingDao = sDao;
        this.zipCodeDao = zDao;
    }
     
    //sighting methods
    public void addSighting(Sighting sighting, Location location){//1
        int locID = locationDao.addSightingLocation(location);
        sightingDao.addSighting(sighting, locID);
    }
    public void deleteSighting(int sightingID){//2
        sightingDao.deleteSighting(sightingID);
    }
    public List<Sighting> getAllSightings(){//3
        return sightingDao.getAllSightings();
    }
    public Sighting getSightingByID(int sightingID){//4
        return sightingDao.getSightingByID(sightingID);
    }
    public void updateSighting(LocalDate dateOfSighting, int sightingID, int heroID, int locationID){//5
        sightingDao.updateSighting(dateOfSighting, sightingID, heroID, locationID);
    }
    public List<Sighting> getAllTopSightings(){
        return sightingDao.getAllTopSightings();
    }
     
    //locations
    public void addLocation(Location locationID){//1
         locationDao.addLocation(locationID);
    }
    public void deleteLocation(int locationID){//2
        locationDao.deleteLocation(locationID);
    }
    public void updateLocation(Location location){//3
        locationDao.updateLocation(location);
    }
    public Location getLocationByID(int locationID){//4
        return locationDao.getLocationByID(locationID);
    }
    public List<Location> getAllLocations(){//5
        return locationDao.getAllLocations();
    }
    public List<Location> getLocationsByHero(int heroID){//6      
        return locationDao.getLocationsByHero(heroID);
    }
     
    //members
    public void addMember(Member member, int organizationID){//1
        memberDao.addMember(member, organizationID);
    }
    public void deleteMember(int memberID){//2
        memberDao.deleteMember(memberID);
    }
    public void updateMember(Member member, int organizationID){//3
        memberDao.updateMember(member, organizationID);
    }
    public Member getMemberByID(int memberID){//4
        return memberDao.getMemberByID(memberID);
    }
    public  List<Member> getAllMembers(){//5
        return memberDao.getAllMembers();
    }
    public List<Member> getMembersByOrganization(){//6
        return memberDao.getMembersByOrganization();
    }
     
    //organizations 
    public void addOrganization(Organization organization){//1 
        organizationDao.addOrganization(organization);
    }
    public void deleteOrganization(int organizationID){//2
        organizationDao.deleteOrganization(organizationID);
    }
    public void updateOrganization(Organization organization){//3
        organizationDao.updateOrganization(organization);
    }
    public Organization getOrganizationByID(int organizationID){//4    
        return organizationDao.getOrganizationByID(organizationID);
    }
    public List<Organization> getOrganizationsByHero(int heroID){//6
        return organizationDao.getOrganizationsByHero(heroID);
    }
    public List<Organization> getAllOrganizations(){
        return organizationDao.getAllOrganizations();
    }    
    public List<String> getAllOrganizationNames(){
        return organizationDao.getOrganizationNames();
    }
    //superHero methods
    public SuperHero getHeroByID(int heroID){
        return heroDao.getHeroById(heroID);
    }    
    public void deleteHero(int heroID){
        heroDao.deleteHero(heroID);
    }                    
    public void updateHero(SuperHero hero, int organizationID){
        heroDao.updateHero(hero, organizationID);        
    }    
    public String getheroOrganization(int heroID){
        String organizationName="";
        return organizationName;
    }
    public SuperHero getHeroByLocation(int heroID){
        return heroDao.getHeroByLocation(heroID);
    }
    public List<SuperHero> getHeroByDate(String date){
        return heroDao.getHeroByDate(date);
    }
    public List<SuperHero> getHeroLocationByDate(String Date){
        return heroDao.getHeroLocationByDate(Date);
    }    
    public void addHero(SuperHero hero, int organizationID){
        heroDao.addHero(hero, organizationID);
    }    
    public List<SuperHero> getAllHeros(){
        return heroDao.getAllHeros();        
    }
    
    
    
    //zipcodeInfo methods
    public void addZipCode(ZipCodeInfo zipCode){//1
        zipCodeDao.addZipCode(zipCode);
    }
    public void deleteZipCode(String zipCode){//2    
        zipCodeDao.deleteZipCode(zipCode);
    }
    public ZipCodeInfo getZipCodeByID(String zipCode){//4
        return zipCodeDao.getZipCodeByID(zipCode);
    }
    public List<ZipCodeInfo> getAllZipCodes(){    //5
        return zipCodeDao.getAllZipCodes();
    }
    
}
