/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;
import com.sg.dvdlibraryspringmvc.model.DVD;
import java.util.List;

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
    public DVD getDVDByTitle(String title);
    public DVD getDVDByReleaseDate(String releaseDate);
    public DVD getDVDByDirector(String director);
    public DVD getDVDByRating(String rating);
}
