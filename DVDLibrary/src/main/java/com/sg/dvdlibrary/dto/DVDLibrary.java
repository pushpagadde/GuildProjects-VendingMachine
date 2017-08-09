/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author apprentice
 */
public class DVDLibrary {
    private String title;
    private String releaseDate;
    private int MPAARating;
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
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public int getMPAARating() {
        return MPAARating;
    }
    public void setMPAARating(int MPAARating) {
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
}
