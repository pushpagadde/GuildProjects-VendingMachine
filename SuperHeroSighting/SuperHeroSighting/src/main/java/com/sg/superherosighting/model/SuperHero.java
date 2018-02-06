/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author PG
 */
public class SuperHero {
    private int HeroID;
    @NotEmpty(message = "You must enter Hero name.")
    @Length(max = 20, message="Hero name cannot be more than 20 characters.")    
    private String HeroName;
    @NotEmpty(message = "You must enter hero power.")
    @Length(max = 20, message="Description cannot be more than 20 characters.")    
    private String HeroPower;

    public int getHeroID() {
        return HeroID;
    }

    public void setHeroID(int HeroID) {
        this.HeroID = HeroID;
    }

    public String getHeroName() {
        return HeroName;
    }

    public void setHeroName(String HeroName) {
        this.HeroName = HeroName;
    }

    public String getHeroPower() {
        return HeroPower;
    }

    public void setHeroPower(String HeroPower) {
        this.HeroPower = HeroPower;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.HeroID;
        hash = 59 * hash + Objects.hashCode(this.HeroName);
        hash = 59 * hash + Objects.hashCode(this.HeroPower);
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
        final SuperHero other = (SuperHero) obj;
        if (this.HeroID != other.HeroID) {
            return false;
        }
        if (!Objects.equals(this.HeroName, other.HeroName)) {
            return false;
        }
        if (!Objects.equals(this.HeroPower, other.HeroPower)) {
            return false;
        }
        return true;
    }
                            
}
