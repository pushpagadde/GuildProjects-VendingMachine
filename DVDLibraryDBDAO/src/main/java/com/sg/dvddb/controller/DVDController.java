/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvddb.controller;


import com.sg.dvddb.dao.DVDDao;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.sg.dvddb.model.DVDInfo;
import com.sg.dvddb.service.DVDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PG
 */
@Controller
public class DVDController {
    DVDService service;    
    
    @Inject
    public DVDController(DVDService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/createDVDPage", method = RequestMethod.POST)
    public String createDVDPage(HttpServletRequest request,Model model) {
        DVDInfo dvd = new DVDInfo();
        model.addAttribute("dvd", dvd);       
        return "createDVDPage";
    }

    @RequestMapping(value = "/createDVD", method = RequestMethod.POST)
    public String createDVD(@Valid @ModelAttribute("dvd") DVDInfo dvd, BindingResult result,
                            @RequestParam(required=false , value = "cancel") String cancelFlag, 
                             HttpServletRequest request) {
        if(result.hasErrors()){
            return"createDVDPage";
        }
        if (cancelFlag == null){            
            DVDInfo dvd1 = new DVDInfo();
            dvd1.setTitle(request.getParameter("title"));
            dvd1.setReleaseYear(request.getParameter("releaseYear"));
            dvd1.setDirector(request.getParameter("director"));
            dvd1.setRating(request.getParameter("rating"));
            dvd1.setNotes(request.getParameter("notes"));
            service.addDVD(dvd1);            
        }
        return "redirect:displayDVDPage";
    }    
    @RequestMapping(params = "saveEdit", method = RequestMethod.POST)
    public String editDVD(@Valid @ModelAttribute("dvd") DVDInfo dvd, BindingResult result,
                          @RequestParam(required=false , value = "cancel") String cancelFlag) {
        if(result.hasErrors()) {
            return "displayEditDVDPage";
        }
        if (cancelFlag == null){            
            service.updateDVD(dvd);
        }   
        return "redirect:displayDVDPage";        
    }            
    
    @RequestMapping(value = "/displayDVDPage", method = RequestMethod.GET)
    public String displayDVDPage(Model model) {
        List<DVDInfo> dvdList = service.getAllDVDs();
        model.addAttribute("dvdList", dvdList);       
        return "dvds";
    }
    
    @RequestMapping(value = "/displayDVDDetails", method = RequestMethod.GET)
    public String displayDVDDetails(HttpServletRequest request, Model model) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        DVDInfo dvd = service.getDVDById(dvdId);
        model.addAttribute("dvd", dvd);        
        return "displayDVDDetails";
    }
    
    @RequestMapping(params= "cancel", method = RequestMethod.POST)
    public String cancel(HttpServletRequest request) {
        return "redirect:displayDVDPage";
    }
    
    @RequestMapping(value = "/displayEditDVDPage", method = RequestMethod.GET)
    public String displayEditDVDPage(HttpServletRequest request, Model model) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        DVDInfo dvd = service.getDVDById(dvdId);
        model.addAttribute("dvd", dvd);
        return "displayEditDVDPage";
    }

    
    @RequestMapping(value = "/deleteDVD", method = RequestMethod.GET)
    public String deleteDVD(HttpServletRequest request) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        service.removeDVD(dvdId);
        return "redirect:displayDVDPage";
    }
}