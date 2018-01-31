/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvddb.service;

import com.sg.dvddb.dao.DVDDao;
import com.sg.dvddb.model.DVDInfo;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author PG
 */
public class DVDService {
    DVDDao dao;

    @Inject
    public DVDService(DVDDao dao) {
        this.dao = dao;
    }
    
    public void addDVD(DVDInfo dvd) {
        dao.addDVD(dvd);
    }
    
    public void removeDVD(long dvdId){
        dao.removeDVD(dvdId);
    }
    
    public void updateDVD(DVDInfo dvd) {
        dao.updateDVD(dvd);
    }
    
    public DVDInfo getDVDById(int dvdId) {
         return dao.getDVDById(dvdId);
    }
    
    public List<DVDInfo> getAllDVDs(){
        return dao.getAllDVDs();
    }
    
    public List<DVDInfo> getDVDByTitle(String title){
        return dao.getDVDByTitle(title);
    }
    
    public List<DVDInfo> getDVDByReleaseDate(String releaseYear) {
        return dao.getDVDByReleaseDate(releaseYear);
    }
    
    public List<DVDInfo> getDVDByDirector(String director){
        return dao.getDVDByDirector(director);
    }
    
    public List<DVDInfo> getDVDByRating(String rating) {
        return dao.getDVDByRating(rating);
    }
    
    
}
