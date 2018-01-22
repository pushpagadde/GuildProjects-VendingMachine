/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc2.model;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
/**
 *
 * @author PG
 */
public class DVD {
    private long dvdId;
    @NotEmpty(message = "You must supply a value for Title.")
    @Length(max = 50, message = "Title must be no more than 50 characters in length.")
    private String title;
    @NotEmpty(message = "You must supply a value for release year.")
    @Length(max = 4, message = "Year must be 4 numbers in length.")    
    private String releaseYear;
    @NotEmpty(message = "You must supply a value for Director.")
    @Length(max = 50, message = "Director name must be no more than 30 characters in length.")    
    private String director;
    @NotEmpty(message = "You must supply a value for Rating.")
    @Length(max = 50, message = "Rating must be no more than 5 characters in length.")    
    private String rating;
    private String notes;

    public long getDvdId() {
        return dvdId;
    }

    public void setDvdId(long dvdId) {
        this.dvdId = dvdId;
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
        hash = 71 * hash + (int) (this.dvdId ^ (this.dvdId >>> 32));
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.releaseYear);
        hash = 71 * hash + Objects.hashCode(this.director);
        hash = 71 * hash + Objects.hashCode(this.rating);
        hash = 71 * hash + Objects.hashCode(this.notes);
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
        final DVD other = (DVD) obj;
        if (this.dvdId != other.dvdId) {
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
