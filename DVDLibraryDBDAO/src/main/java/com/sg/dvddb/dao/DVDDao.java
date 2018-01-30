/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvddb.dao;

import java.util.List;
import java.util.Map;
import com.sg.dvddb.model.DVDInfo;

/**
 *
 * @author PG
 */
public interface DVDDao {
    public void addDVD(DVDInfo dvd);
    public void removeDVD (long dvdId);
    public void updateDVD(DVDInfo dvd);
    public List<DVDInfo> getAllDVDs();
    public DVDInfo getDVDById(int dvdId);    
    public List<DVDInfo> getDVDByTitle(String title);
    public List<DVDInfo> getDVDByReleaseDate(String releaseDate);
    public List<DVDInfo> getDVDByDirector(String director);
    public List<DVDInfo> getDVDByRating(String rating);
    //public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);
    
}
