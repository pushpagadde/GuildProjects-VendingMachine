/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.controller;
import com.sg.superherosighting.model.Location;
import com.sg.superherosighting.model.Member;
import com.sg.superherosighting.model.Organization;
import com.sg.superherosighting.model.Sighting;
import com.sg.superherosighting.model.SuperHero;
import com.sg.superherosighting.model.ZipCodeInfo;
import com.sg.superherosighting.service.HeroService;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PG
 */
@CrossOrigin
@Controller
public class MainController { 
    HeroService service;
    
    @Inject
    public MainController(HeroService service){
        this.service = service;
    }
    

    //method to go to the main page of the application
    @RequestMapping(value = "/mainPage", method=RequestMethod.GET )
    public String mainPage(Model model){
        List<Sighting> sightings = service.getAllTopSightings();
        List<Location> locations = service.getAllLocations();
        List<SuperHero> heros = service.getAllHeros();
        model.addAttribute("heros", heros);
        model.addAttribute("sightings", sightings);
        model.addAttribute("locations",locations);        
        return "mainPage";
    }

    //method to retrieve location information
    @RequestMapping(value = "/sightingEditPageJsonCall/{locationid}"  , method = RequestMethod.POST   )
    @ResponseBody
    public Location sightingEditPageJasonCall(@PathVariable("locationid") int locationid) {
        return service.getLocationByID(locationid);
    }    
    
    //method to load create hero page
    @RequestMapping( value = "/createHero", method = RequestMethod.POST)
    public String createHero(HttpServletRequest request) {        
        SuperHero hero = new SuperHero();
        hero.setHeroName(request.getParameter("heroName"));
        hero.setHeroPower(request.getParameter("heroPower"));
        int organizationID = Integer.parseInt( request.getParameter("organization"));            
        service.addHero(hero,organizationID); 
        return "redirect:displayHerosPage";
    }
    
    //method to save edits on hero
    @RequestMapping(params = "saveHero", method = RequestMethod.POST)
    public String editHero(@Valid @ModelAttribute("hero") SuperHero hero, HttpServletRequest request,
                           @RequestParam(required=false , value = "Cancel") String cancelFlag, BindingResult result ) {
        if (result.hasErrors()) {
            return "displayEditHeroPage";
        }
        if(cancelFlag == null){
            int organizationID = Integer.parseInt( request.getParameter("organization"));  
            service.updateHero(hero, organizationID);   
        }        
        return "redirect:displayHerosPage";
    }        
    
    //cancel edit hero
    @RequestMapping(params= "cancel", method = RequestMethod.POST)
    public String cancel() {
        return "redirect:displayHerosPage";
    }    
    
    //method to display pull organizations information for dropdown and fill heros table
    @RequestMapping(value = "displayHerosPage", method=RequestMethod.GET )
    public String displayHerosPage(  Model model){
        List<SuperHero> heroList = service.getAllHeros();
        List<Organization> organizations = service.getAllOrganizations();        
        model.addAttribute("heroList", heroList);
        model.addAttribute("organizations", organizations);        
        return "superHero";
    }
    
    //method to display hero details, picked from the table
    @RequestMapping(value = "/displayHeroDetails", method = RequestMethod.GET)
    public String displayHeroDetails( HttpServletRequest request, Model model) {
        String heroIDParameter = request.getParameter("heroID");
        int heroID = Integer.parseInt(heroIDParameter);
        SuperHero hero = service.getHeroByID(heroID);
        model.addAttribute("hero", hero);
        return "displayHeroDetails";
    }    
    //method for go back button press
    @RequestMapping(value="superHero", method=RequestMethod.GET)
    public String displayHerosPage() {
        return "redirect:displayHerosPage";
    }    
    
    //method to delete hero
    @RequestMapping(value = "/deleteHero", method = RequestMethod.GET)
    public String deleteHero(HttpServletRequest request) {
        String heroIDParameter = request.getParameter("heroID");
        int heroId = Integer.parseInt(heroIDParameter);
        service.deleteHero(heroId);
        return "redirect:displayHerosPage";
    }
    //method to edit hero page
    @RequestMapping(value = "/displayEditHeroPage", method = RequestMethod.GET)
    public String displayEditHeroPage(HttpServletRequest request, Model model) {
        String heroIDParameter = request.getParameter("heroID");
        int heroID = Integer.parseInt(heroIDParameter);
        SuperHero hero = service.getHeroByID(heroID);        
        List<Organization> organizationNames = service.getAllOrganizations();  
        int orgID = -1;
        List<Organization> org = service.getOrganizationsByHero(hero.getHeroID());
        if (org != null && org.size() > 0){
            orgID = org.get(0).getOrganizationID();
        }
        model.addAttribute("organizationNames",organizationNames);
        model.addAttribute("hero", hero);
        model.addAttribute("heroOrgId", orgID);
        return "editHeroPage";
    }
    
    //organization methods
    //method to display pull organizations information table
    @RequestMapping(value = "displayOrganizationsPage", method=RequestMethod.GET )
    public String displayOrganizationsPage(Model model){
        List<Organization> organizationsList = service.getAllOrganizations();        
        model.addAttribute("organizationsList",organizationsList);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();        
        model.addAttribute("zipCodes",zipCodes);
        return "organization";
    }     
    
    //create organization method
    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization( HttpServletRequest request) {                
        Organization organization = new Organization();
        organization.setOrganizationName(request.getParameter("organizationName"));
        organization.setAddress(request.getParameter("organizationAddress"));
        organization.setZipCode(request.getParameter("zipCode"));
        organization.setPhone(request.getParameter("organizationPhone"));        
        service.addOrganization(organization);
        return "redirect:displayOrganizationsPage";        
    }
    //view organization details
    @RequestMapping(value = "/organizationDetailsPage", method = RequestMethod.GET)
    public String organizationDetailsPage(HttpServletRequest request, Model model) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);
        Organization organization = service.getOrganizationByID(organizationID);
        ZipCodeInfo zipCode = service.getZipCodeByID(organization.getZipCode());
        model.addAttribute("organization",organization);
        model.addAttribute("zipCode",zipCode);
        return "organizationDetailsPage";
    }    
    //method for go back button press
    @RequestMapping(value="organization", method=RequestMethod.GET)
    public String displayOrganizationsPage() {
        return "redirect:displayOrganizationsPage";
    }        
    
    //edit organization method
    @RequestMapping(value = "/organizationEditPage", method = RequestMethod.GET)
    public String organizationEditPage(HttpServletRequest request, Model model){
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();
        Organization organization = service.getOrganizationByID(organizationID);
        model.addAttribute("organization",organization);
        model.addAttribute("zipCodes",zipCodes);
        return "organizationEditPage";
    }    
            
    //save edit organization method      
    @RequestMapping(params = "saveOrganization", method = RequestMethod.POST)
    public String editOrganization(@Valid @ModelAttribute("organization") Organization organization, HttpServletRequest request,
                           @RequestParam(required=false , value = "cancel") String cancelFlag, BindingResult result ) {
        if (result.hasErrors()) {
            return "organizationEditPage";
        }
        if(cancelFlag == null){
            service.updateOrganization(organization);            
        }        
        return "redirect:organization";
    }            
    
    //edit cancel method
    @RequestMapping(params= "cancelOrgEdit", method = RequestMethod.POST)
    public String cancelOrganizationEdit() {
        return "redirect:organization";
    }   
    
    //delete organization method
    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);
        service.deleteOrganization(organizationID);
        return "redirect:organization";
    }
    
    //members methods
    //load members jsp page
    @RequestMapping(value="displayMembersPage", method=RequestMethod.GET)
    public String displayMembersPage(Model model) {
        List<Member> membersList = service.getAllMembers();
        model.addAttribute("membersList",membersList);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();        
        model.addAttribute("zipCodes",zipCodes);        
        List<Organization> organizations = service.getAllOrganizations();
        model.addAttribute("organizations", organizations);
        return "member";
    }
    //method to add new member
    @RequestMapping(value = "/createMember", method = RequestMethod.POST)
    public String createMember( HttpServletRequest request) {
        
        Member member = new Member();
        member.setFirstName(request.getParameter("firstName"));
        member.setLastName(request.getParameter("lastName"));
        member.setAddress(request.getParameter("address"));
        member.setZipCode(request.getParameter("zipCode"));
        String organizationIDParameter = request.getParameter("organization");
        int organizationID = Integer.parseInt(organizationIDParameter);
        service.addMember(member, organizationID );
        return "redirect:displayMembersPage";        
    }
            
    //method to view member details
    @RequestMapping(value = "/memberDetailsPage", method = RequestMethod.GET)
    public String memberDetailsPage(HttpServletRequest request, Model model) {
        String memberIDParameter = request.getParameter("memberID");
        int memberID = Integer.parseInt(memberIDParameter);
        Member member = service.getMemberByID(memberID);            
        ZipCodeInfo zipCode = service.getZipCodeByID(member.getZipCode());        
        model.addAttribute("member",member);
        model.addAttribute("zipCode",zipCode);
        return "memberDetailsPage";
    }    
    //method for go back button press
    @RequestMapping(value="member", method=RequestMethod.GET)
    public String displayMembersPage() {
        return "redirect:displayMembersPage";
    }
    
    //open edit page for member
    @RequestMapping(value = "/memberEditPage", method = RequestMethod.GET)
    public String memberEditPage(HttpServletRequest request, Model model){
        String memberIDParameter = request.getParameter("memberID");
        int memberID = Integer.parseInt(memberIDParameter);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();
        Member member = service.getMemberByID(memberID);
        List<Organization> organizations = service.getAllOrganizations();  
        model.addAttribute("member",member);
        model.addAttribute("organizations",organizations);
        model.addAttribute("zipCodes",zipCodes);
        return "memberEditPage";
    }
        
    //save edit member method
    @RequestMapping(params = "saveMember", method = RequestMethod.POST)
    public String editMember(@Valid @ModelAttribute("member") Member member, HttpServletRequest request,
                           @RequestParam(required=false , value = "cancel") String cancelFlag, BindingResult result ) {
        if (result.hasErrors()) {
            return "memberEditPage";
        }        
        if(cancelFlag == null){
            int organizationID = Integer.parseInt( request.getParameter("organization"));
            service.updateMember(member, organizationID);            
        }        
        return "redirect:member";
    }                    
    
    //cancel edit member method
    @RequestMapping(params= "cancelMemberEdit", method = RequestMethod.POST)
    public String cancelMemberEdit() {
        return "redirect:member";
    }
    //delete member method
    @RequestMapping(value = "/deleteMember", method = RequestMethod.GET)
    public String deleteMember(HttpServletRequest request) {
        String memberIDParameter = request.getParameter("memberID");
        int memberID = Integer.parseInt(memberIDParameter);
        service.deleteMember(memberID);
        return "redirect:member";
    }
    
    //Location tab methods
    //load locations page
    @RequestMapping(value="displayLocationsPage", method=RequestMethod.GET)
    public String displayLocationsPage(@ModelAttribute("location") Location location, Model model) {       
        List<Location> locationsList = service.getAllLocations();
        model.addAttribute("locationsList",locationsList);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();        
        model.addAttribute("zipCodes",zipCodes);        
        return "location";
    }
    
    //add new location
    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation( HttpServletRequest request) {
        
        Location location = new Location();
        location.setDescription(request.getParameter("description"));
        location.setAddress(request.getParameter("address"));
        location.setZipCode(request.getParameter("zipCode"));
        location.setLongitude(request.getParameter("longitude"));
        location.setLatitude(request.getParameter("latitude"));
        service.addLocation(location);        
        return "redirect:displayLocationsPage";        
    }

    //view location details
    @RequestMapping(value = "/locationDetailsPage", method = RequestMethod.GET)
    public String locationDetailsPage(HttpServletRequest request, Model model) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        Location location = service.getLocationByID(locationID);            
        ZipCodeInfo zipCode = service.getZipCodeByID(location.getZipCode());        
        model.addAttribute("location",location);
        model.addAttribute("zipCode",zipCode);
        return "locationDetailsPage";
    }
    //location details back method
    @RequestMapping(value="location", method=RequestMethod.GET)
    public String displayLocationsPage() {
        return "redirect:displayLocationsPage";
    }
    
    //view location to edit
    @RequestMapping(value = "/locationEditPage", method = RequestMethod.GET)
    public String locationEditPage(HttpServletRequest request, Model model){
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();
        Location location = service.getLocationByID(locationID);
        List<Organization> organizations = service.getAllOrganizations();  
        model.addAttribute("location",location);
        model.addAttribute("organizations",organizations);
        model.addAttribute("zipCodes",zipCodes);
        return "locationEditPage";
    }
        
    //save location edit
    @RequestMapping(params = "saveLocation", method = RequestMethod.POST)
    public String editLocation(@ModelAttribute("location") Location location, HttpServletRequest request,
                           @RequestParam(required=false , value = "cancelLocationEdit") String cancelFlag ) {
        
        if(cancelFlag == null){            
            service.updateLocation(location);            
        }        
        return "redirect:location";
    }
    
    
    
    //cancel edit location
    @RequestMapping(params= "cancelLocationEdit", method = RequestMethod.POST)
    public String cancelLocationEdit() {
        return "redirect:location";
    }
    
    //delete location
    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        service.deleteLocation(locationID);
        return "redirect:location";
    }
    
    //sightings tab methods    
    //display sightings tab
    @RequestMapping(value="displaySightingsPage", method=RequestMethod.GET)
    public String displaySightingsPage(Model model) {
        List<Location> locations = service.getAllLocations();
        model.addAttribute("locations",locations);
        List<ZipCodeInfo> zipCodes = service.getAllZipCodes();        
        model.addAttribute("zipCodes",zipCodes);        
        List<SuperHero> heros = service.getAllHeros();
        model.addAttribute("heros",heros);
        List<Sighting> sightingsList = service.getAllSightings();
        model.addAttribute("sightingsList",sightingsList);
        return "sighting";
    }    
    
    //create new sighting
    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting( HttpServletRequest request) throws ParseException {
        
        LocalDate date;
        
        Location location = new Location();
        location.setDescription(request.getParameter("description"));
        location.setAddress(request.getParameter("address"));
        location.setZipCode(request.getParameter("zipCode"));
        location.setLongitude(request.getParameter("longitude"));
        location.setLatitude(request.getParameter("latitude"));        
        Sighting sighting = new Sighting();
        
        int heroID = Integer.parseInt(request.getParameter("heroID"));
        sighting.setHeroID(heroID);        
        String sightingDate = request.getParameter("dateOfSighting");
        try {
            date = LocalDate.parse(sightingDate);
        } catch (DateTimeParseException e) {
            return "redirect:displaySightingsPage";
        }
        if (date != null) {
            sighting.setDateOfSighting(date);
        }
        service.addSighting(sighting, location);
        return "redirect:displaySightingsPage";        
    }
    
    //view sighting details
    @RequestMapping(value = "/sightingDetailsPage", method = RequestMethod.GET)
    public String sightingDetailsPage(HttpServletRequest request, Model model) {
        String sightingIDParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIDParameter);
        Sighting sighting = service.getSightingByID(sightingID);     
        SuperHero hero = service.getHeroByID(sighting.getHeroID());
        Location location = service.getLocationByID(sighting.getLocationID());            
        ZipCodeInfo zipCode = service.getZipCodeByID(location.getZipCode());
        model.addAttribute("hero",hero);
        model.addAttribute("sighting", sighting);
        model.addAttribute("location",location);
        model.addAttribute("zipCode",zipCode);
        return "sightingDetailsPage";
    }
    
    //sighting details back method
    @RequestMapping(value="sighting", method=RequestMethod.GET)
    public String displaySightingsPage() {
        return "redirect:displaySightingsPage";
    }
    
    //open sighting for edit        
    @RequestMapping(value = "/sightingEditPage", method = RequestMethod.GET)
    public String sightingEditPage(HttpServletRequest request, Model model){        
        String sightingIDParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIDParameter);
        Sighting sighting = service.getSightingByID(sightingID);
        Location location = service.getLocationByID(sighting.getLocationID());
        SuperHero hero = service.getHeroByID(sighting.getHeroID());
        List<Location> locations = service.getAllLocations();
        List<SuperHero> heros = service.getAllHeros();
        ZipCodeInfo zipCode = service.getZipCodeByID(location.getZipCode());
        model.addAttribute("sighting",sighting);
        model.addAttribute("location",location);
        model.addAttribute("hero",hero);        
        model.addAttribute("zipCode",zipCode);
        model.addAttribute("locations",locations);
        model.addAttribute("heros",heros);        
        
        return "sightingEditPage";
    }

    //saving sighting edit
    @RequestMapping(value = "saveSighting", method = RequestMethod.POST)
    public String saveSighting(String dateOfSighting, HttpServletRequest request,
            @RequestParam(required=false , value = "cancelSightingsEdit") String cancelFlag)  {
        LocalDate date = null;
        if (cancelFlag == null){
            String sightingID = request.getParameter("sightingID");
            String heroID = request.getParameter("heroN");
            String locationID = request.getParameter("locationN");
            try {
                date = LocalDate.parse(dateOfSighting);
            } catch (DateTimeParseException e) {
                return "redirect:displaySightingsPage";
            }
            if (date != null && sightingID != null) {
                service.updateSighting(date, Integer.parseInt(sightingID), Integer.parseInt(heroID), Integer.parseInt(locationID));
            }
        }
        return "redirect:displaySightingsPage";
    }            
/*    
    //cancel edit sighting 
    @RequestMapping(params= "cancelSightingsEdit", method = RequestMethod.POST)
    public String cancelSightingEdit() {
        return "redirect:sighting";
    }
  */  
    //delete sighting
    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingIDParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIDParameter);
        service.deleteSighting(sightingID);
        return "redirect:sighting";
    }            
}