/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Order {
    private int    orderNumber;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double costPerSquareFoot;
    private double laborCostPerSquareFoot;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double total;
    //order number, customer name, state, tax rate, product type, 
    //area, cost per square foot, labor cost per square foot, 
    //material cost, labor cost, tax, and total

    public Order(){
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.orderNumber;
        hash = 97 * hash + Objects.hashCode(this.customerName);
        hash = 97 * hash + Objects.hashCode(this.state);
        hash = 97 * hash + Objects.hashCode(this.taxRate);
        hash = 97 * hash + Objects.hashCode(this.productType);
        hash = 97 * hash + Objects.hashCode(this.area);
        hash = 97 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 97 * hash + Objects.hashCode(this.laborCostPerSquareFoot);
        hash = 97 * hash + Objects.hashCode(this.materialCost);
        hash = 97 * hash + Objects.hashCode(this.laborCost);
        hash = 97 * hash + Objects.hashCode(this.tax);
        hash = 97 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {           return true;         }
        if (obj == null) {           return false;        }
        if (getClass() != obj.getClass()) {            return false;        }
        
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {            return false;        }
        if (this.customerName != other.customerName) {            return false;        }
        if (!Objects.equals(this.customerName, other.customerName)) {            return false;        }
        if (!Objects.equals(this.state, other.state)) {            return false;        }
        return true;
    }
    //order number, customer name, state, tax rate, product type, 
    //area, cost per square foot, labor cost per square foot, 
    //material cost, labor cost, tax, and total
    
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double getCostPerSquareFoot() {
        return costPerSquareFoot;
    }
    public void setCostPerSquareFoot(double costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }
    public double getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }
    public void setLaborCostPerSquareFoot(double laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }
    public double getMaterialCost() {
        return materialCost;
    }
    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }
    public double getLaborCost() {
        return laborCost;
    }
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
