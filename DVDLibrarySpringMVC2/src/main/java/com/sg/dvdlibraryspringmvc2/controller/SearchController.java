/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc2.controller;
import com.sg.dvdlibraryspringmvc2.dao.DVDListDao;
import com.sg.dvdlibraryspringmvc2.dao.SearchTerm;
import com.sg.dvdlibraryspringmvc2.model.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author PG
 */
@Controller
public class SearchController {
    DVDListDao dao;
    
    @Inject
    public SearchController(DVDListDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/searchDVDPage", method=RequestMethod.POST)
    public String displaySearchPage(HttpServletRequest request, Model model) {
        List<DVD> dvdList = new ArrayList<>();
        String category = request.getParameter("searchCategory");
        String term = request.getParameter("searchTerm");
        dvdList = dao.getDVDByTitle(term);
        model.addAttribute("dvdList", dvdList);
        return "searchDVDPage";
    }
    /*
    @RequestMapping(value = "/search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchDVDs(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();

        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        String currentTerm = searchMap.get("firstName");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }
        currentTerm = searchMap.get("lastName");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RELEASE_YEAR, currentTerm);
        }
        currentTerm = searchMap.get("company");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RATING, currentTerm);
        }
        currentTerm = searchMap.get("email");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTOR, currentTerm);
        }

        return dao.searchDVDs(criteriaMap);
    }*/
}
