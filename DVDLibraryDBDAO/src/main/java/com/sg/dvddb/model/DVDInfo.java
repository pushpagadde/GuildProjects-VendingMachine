/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvddb.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author PG
 */
public class DVDInfo {
    private int dvdID;
    @NotEmpty(message = "You must supply a value for Title of the DVD.")
    @Length(max = 30, message = "Title must be no more than 30 characters in length.")    
    private String title;
    @NotEmpty(message = "You must supply a 4 digit year.")
    @Length(max = 4, message = "Release Year must be 4 years in length")    
    private String releaseYear;
    @NotEmpty(message = "You must supply a value for Directors name.")
    @Length(max = 20, message = "Directors name must not be more than 20 characters in length.")        
    private String director;
    @NotEmpty(message = "You must supply a value for movie rating.")
    @Length(max = 5, message = "Rating must not be more than 5 characters in length.")        
    private String rating;
    @Length(max = 30, message = "Title must be no more than 30 characters in length.")        
    private String notes;

    public int getDvdID() {
        return dvdID;
    }

    public void setDvdID(int dvdID) {
        this.dvdID = dvdID;
    }
    public String getTitle() {
        return title;
    }   

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.dvdID;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.releaseYear);
        hash = 97 * hash + Objects.hashCode(this.director);
        hash = 97 * hash + Objects.hashCode(this.rating);
        hash = 97 * hash + Objects.hashCode(this.notes);
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
        final DVDInfo other = (DVDInfo) obj;
        if (this.dvdID != other.dvdID) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseYear, other.releaseYear)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        return true;
    }
    
    
    
           
    
}
