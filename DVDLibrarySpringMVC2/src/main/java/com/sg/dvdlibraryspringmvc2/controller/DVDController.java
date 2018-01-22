/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc2.controller;

import com.sg.dvdlibraryspringmvc2.dao.DVDListDao;
import com.sg.dvdlibraryspringmvc2.model.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    DVDListDao dao;
    
    @Inject
    public DVDController(DVDListDao dao) {
        this.dao = dao;
    }
    @RequestMapping(value = "/createDVDPage", method = RequestMethod.POST)
    public String createDVDPage(HttpServletRequest request) {
        return "createDVDPage";
    }
    
    @RequestMapping(value = "/createDVD", method = RequestMethod.POST)
    public String createDVD(@RequestParam(required=false , value = "cancel") String cancelFlag, HttpServletRequest request) {
        if (cancelFlag == null){            
            DVD dvd = new DVD();
            dvd.setTitle(request.getParameter("title"));
            dvd.setReleaseYear(request.getParameter("releaseYear"));
            dvd.setDirector(request.getParameter("director"));
            dvd.setRating(request.getParameter("rating"));
            dvd.setNotes(request.getParameter("notes"));
            dao.addDVD(dvd);            
        }
        return "redirect:displayDVDPage";
    }
    
    @RequestMapping(value = "/displayDVDPage", method = RequestMethod.GET)
    public String displayDVDPage(Model model) {
        List<DVD> dvdList = dao.getAllDVDs();
        model.addAttribute("dvdList", dvdList);
        return "dvds";
    }
    
    @RequestMapping(value = "/displayDVDDetails", method = RequestMethod.GET)
    public String displayDVDDetails(HttpServletRequest request, Model model) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        DVD dvd = dao.getDVDById(dvdId);
        model.addAttribute("dvd", dvd);
        return "dvdDetails";
    }
    
    @RequestMapping(params= "cancel", method = RequestMethod.POST)
    public String cancel(HttpServletRequest request) {
        return "redirect:displayDVDPage";
    }

    @RequestMapping(params = "saveEdit", method = RequestMethod.POST)
    public String editDVD(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result,
                          @RequestParam(required=false , value = "cancel") String cancelFlag) {
        if(result.hasErrors()) {
            return "editDVDPage";
        }
        if (cancelFlag == null){
            dao.updateDVD(dvd);
        }   
        return "redirect:displayDVDPage";        
    }
    
    @RequestMapping(value = "/displayEditDVDPage", method = RequestMethod.GET)
    public String displayEditDVDPage(HttpServletRequest request, Model model) {
        String dvdIdParameter = request.getParameter("dvdId");
        long dvdId = Long.parseLong(dvdIdParameter);
        DVD dvd = dao.getDVDById(dvdId);
        model.addAttribute("dvd", dvd);
        return "editDVDPage";
    }
    
    @RequestMapping(value = "/deleteDVD", method = RequestMethod.GET)
    public String deleteDVD(HttpServletRequest request) {
        String dvdIdParameter = request.getParameter("dvdId");
        long dvdId = Long.parseLong(dvdIdParameter);
        dao.removeDVD(dvdId);
        return "redirect:displayDVDPage";
    }   
}