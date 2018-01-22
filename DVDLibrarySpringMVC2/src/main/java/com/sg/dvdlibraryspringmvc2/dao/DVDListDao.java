/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc2.dao;

import com.sg.dvdlibraryspringmvc2.model.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PG
 */
public interface DVDListDao {
    public DVD addDVD(DVD dvd);
    public void removeDVD (long dvdId);
    public void updateDVD(DVD dvd);
    public List<DVD> getAllDVDs();
    public DVD getDVDById(long dvdId);  
    public List<DVD> getDVDByTitle(String title);
    public DVD getDVDByReleaseDate(String releaseDate);
    public DVD getDVDByDirector(String director);
    public DVD getDVDByRating(String rating);
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);
}
