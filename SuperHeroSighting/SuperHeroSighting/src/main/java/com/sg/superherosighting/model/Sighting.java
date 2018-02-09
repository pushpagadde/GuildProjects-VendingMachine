/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author PG
 */
public class Sighting {
    private int sightingID;
    private int heroID;
    private int locationID;
    private LocalDate dateOfSighting;

    public int getSightingID() {
        return sightingID;
    }

    public void setSightingID(int sightingID) {
        this.sightingID = sightingID;
    }

    public int getHeroID() {
        return heroID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public LocalDate getDateOfSighting() {
        return dateOfSighting;
    }

    public void setDateOfSighting(LocalDate dateOfSighting) {
        this.dateOfSighting = dateOfSighting;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.sightingID;
        hash = 13 * hash + this.heroID;
        hash = 13 * hash + this.locationID;
        hash = 13 * hash + Objects.hashCode(this.dateOfSighting);
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
        final Sighting other = (Sighting) obj;
        if (this.sightingID != other.sightingID) {
            return false;
        }
        if (this.heroID != other.heroID) {
            return false;
        }
        if (this.locationID != other.locationID) {
            return false;
        }
        if (!Objects.equals(this.dateOfSighting, other.dateOfSighting)) {
            return false;
        }
        return true;
    }          
}
