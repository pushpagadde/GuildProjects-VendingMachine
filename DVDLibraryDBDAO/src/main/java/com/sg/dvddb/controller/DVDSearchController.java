/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvddb.controller;


import com.sg.dvddb.model.DVDInfo;
import com.sg.dvddb.service.DVDService;
import java.util.ArrayList;
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
public class DVDSearchController {    
    DVDService service;
    
    @Inject
    public DVDSearchController(DVDService service) {
        this.service = service;
    }
    
    @RequestMapping(value="/searchDVDResultPage", method=RequestMethod.POST)
    public String displaySearchPage(HttpServletRequest request, Model model) {
        List<DVDInfo> dvdList = new ArrayList<>();
        String category = request.getParameter("searchCategory");
        String term = request.getParameter("searchTerm");
        switch(category) {
            case "Title":
                dvdList = service.getDVDByTitle(term);
                break;
            case "ReleaseYear":
                dvdList = service.getDVDByReleaseDate(term);
                break;
            case "Director":
                dvdList = service.getDVDByDirector(term);
                break;
            case "Rating":
                dvdList = service.getDVDByRating(term);
                break;
            default:
        }        
        model.addAttribute("dvdList", dvdList);
        return "searchDVDResultPage";
    }
}
