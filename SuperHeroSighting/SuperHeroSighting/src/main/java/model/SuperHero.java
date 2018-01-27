/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author PG
 */
public class SuperHero {
    private int HeroID;
    private String HeroName;
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
