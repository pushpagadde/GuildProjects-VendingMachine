/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author PG
 */
public class Item {
    private int itemId;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemQuantity;

    public Item(int id, String itemName, BigDecimal price, int quantity) {
        this.itemId = id;
        this.itemName = itemName;
        this.itemPrice = price;
        this.itemQuantity = quantity;        
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    
    public void addItems(int id, String name, BigDecimal price, int quantity){
        this.itemId = id;
        this.itemName = name;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.itemId;
        hash = 17 * hash + Objects.hashCode(this.itemName);
        hash = 17 * hash + Objects.hashCode(this.itemPrice);
        hash = 17 * hash + this.itemQuantity;
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
        final Item other = (Item) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.itemQuantity != other.itemQuantity) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        return true;
    }        
    
}
