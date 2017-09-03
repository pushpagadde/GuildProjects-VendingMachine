/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class DVDLibrary {
    private String title;
    //private String releaseDate;
    private LocalDate releaseDate = LocalDate.now();
    private String MPAARating;
    private String directorName;
    private String studio;
    private String userNotes;

    public DVDLibrary(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getMPAARating() {
        return MPAARating;
    }
    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }
    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public String getUserNotes() {
        return userNotes;
    }
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.releaseDate);
        hash = 71 * hash + Objects.hashCode(this.MPAARating);
        hash = 71 * hash + Objects.hashCode(this.directorName);
        hash = 71 * hash + Objects.hashCode(this.studio);
        hash = 71 * hash + Objects.hashCode(this.userNotes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVDLibrary other = (DVDLibrary) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.MPAARating, other.MPAARating)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userNotes, other.userNotes)) {
            return false;
        }
        return true;
    }
    
}
