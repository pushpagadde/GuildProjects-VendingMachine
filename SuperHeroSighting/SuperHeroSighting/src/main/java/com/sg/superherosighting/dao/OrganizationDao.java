/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.Organization;

/**
 *
 * @author PG
 */
public interface OrganizationDao {

    //methods for Organization table
    public void addOrganization(Organization organization);//1
    public void deleteOrganization(int organizationID);//2
    public void updateOrganization(Organization organization);//3
    public Organization getOrganizationByID(int organizationID);//4
    public List<Organization> getAllOrganizations();//5
    public List<Organization> getOrganizationsByHero(int heroID);//6
    public List<String> getOrganizationNames();//7
    
}
