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
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author PG
 */
@CrossOrigin
@Controller
public class RESTController {
private DVDListDao dao;

    @Inject
    public RESTController(DVDListDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DVD getDVD(@PathVariable("id") long id) {
        return dao.getDVDById(id);
    }
    
    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DVD createDVD(@Valid @RequestBody DVD dvd) {
        return dao.addDVD(dvd);
    }
    
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable("id") long id) {
        dao.removeDVD(id);
    }
    
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateContact(@PathVariable("id") long id,
                              @Valid @RequestBody DVD dvd) 
                              throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != dvd.getDvdId()) {
            throw new UpdateIntegrityException("Contact Id on URL must match Contact Id in submitted data.");
        }
        dao.updateDVD(dvd);
    }
    
    @RequestMapping(value = "/allDVDs", method = RequestMethod.GET)
    @ResponseBody
    public List<DVD> getAllDVDs() {
        return dao.getAllDVDs();
    }
    
}