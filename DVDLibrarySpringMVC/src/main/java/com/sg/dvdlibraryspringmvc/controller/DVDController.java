/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;
import com.sg.dvdlibraryspringmvc.dao.DVDListDao;
import com.sg.dvdlibraryspringmvc.model.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PG
 */
@Controller
public class DVDController {
    DVDListDao dao;
    
    @Inject
    public DVDController(DVDListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayIndexPage", method = RequestMethod.POST)
    public String displayIndexPage(Model model) {
        // Return the logical name of our View component
        return "index";
    }    
    @RequestMapping(value = "/displayDVDsPage", method = RequestMethod.GET)
    public String displayDVDsPage(Model model) {
        // Get all the DVDs from the DAO
        List<DVD> dvdList = dao.getAllDVDs();
        // Put the List of DVDs on the Model
        model.addAttribute("dvdList", dvdList);
        // Return the logical name of our View component
        //return "redirect:index.jsp";
        return "redirect:createDVDPage";
    } 
    @RequestMapping(value = "/createDVDPage", method = RequestMethod.GET)
    public String createDVD(HttpServletRequest request) {
        return "createDVD";
    }
    @RequestMapping(value = "/saveNewDVD", method = RequestMethod.POST)
    public String saveNewDVD(HttpServletRequest request) {
        // grab the incoming values from the form and create a new Contact
        // object
        DVD dvd = new DVD();
        dvd.setTitle(request.getParameter("title"));
        dvd.setReleaseDate(request.getParameter("releaseDate"));
        dvd.setDirector(request.getParameter("director"));
        dvd.setRating(request.getParameter("rating"));
        dvd.setNotes(request.getParameter("notes"));

        // persist the new Contact
        dao.addDVD(dvd);
        // we don't want to forward to a View component - we want to
        // redirect to the endpoint that displays the Contacts Page
        // so it can display the new Contact in the table.
        return "redirect:displayDVDsPage";
    }
    
    
/*
    
    
    
    @RequestMapping(value = "/displayContactDetails", method = RequestMethod.GET)
    public String displayContactDetails(HttpServletRequest request, Model model) {
        String contactIdParameter = request.getParameter("contactId");
        int contactId = Integer.parseInt(contactIdParameter);
        Contact contact = dao.getContactById(contactId);
        model.addAttribute("contact", contact);
        return "contactDetails";
    }
    
    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(HttpServletRequest request) {
        String contactIdParameter = request.getParameter("contactId");
        long contactId = Long.parseLong(contactIdParameter);
        dao.removeContact(contactId);
        return "redirect:displayContactsPage";
    }
    
    @RequestMapping(value = "/displayEditContactForm", method = RequestMethod.GET)
    public String displayEditContactForm(HttpServletRequest request, Model model) {
        String contactIdParameter = request.getParameter("contactId");
        long contactId = Long.parseLong(contactIdParameter);
        Contact contact = dao.getContactById(contactId);
        model.addAttribute("contact", contact);
        return "editContactForm";
    }
    
    @RequestMapping(value = "/editContact", method = RequestMethod.POST)
public String editContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
    if (result.hasErrors()) {
        return "editContactForm";
    }
    dao.updateContact(contact);
    return "redirect:displayContactsPage";
}

    
    */    
    
    
/*    @RequestMapping(value="/displayDVDsListPage", method=RequestMethod.GET)
    public String displayDVDsListPage() {
        return "dvds";
    }
    @RequestMapping(value="/createDVD", method=RequestMethod.GET)
    public String createDVDPage() {
        return "createDVD";
    }*/
}
