/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.DVD;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PG
 */
public class DVDListDaoInMemImpl implements DVDListDao{

    private Map<Long, DVD> dvdMap = new HashMap<>();
    private static long dvdIdCounter = 0;
    
    @Override
    public DVD addDVD(DVD dvd) {
        dvd.setDvdId(dvdIdCounter);
        dvdIdCounter++;
        dvdMap.put(dvd.getDvdId(), dvd);
        System.out.println("dvd added");
        return dvd;
    }

    @Override
    public void removeDVD(long dvdId) {
        dvdMap.remove(dvdId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        Collection<DVD> c = dvdMap.values();
        return new ArrayList(c);
    }

    @Override
    public DVD getDVDById(long dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public DVD getDVDByTitle(String title) {
        return dvdMap.get(title);
    }

    @Override
    public DVD getDVDByReleaseDate(String releaseDate) {
        return dvdMap.get(releaseDate);
    }

    @Override
    public DVD getDVDByDirector(String director) {
        return dvdMap.get(director);
    }

    @Override
    public DVD getDVDByRating(String rating) {
        return dvdMap.get(rating);
    }    
    
    /*using streams for searching
    Predicate<DVD> truePredicate = (c) -> {
            return true;
        };
    
    if(searchCriteria == null || searchTerm.isEmpty()){
        searchPredicate = truePredicate;    
    }else {
        searchPredicate = c.getTitle().equals(searchterm);
    }
    
    */
}
