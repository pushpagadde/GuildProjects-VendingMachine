/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.text.DecimalFormat;
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
    private static DecimalFormat df2 = new DecimalFormat(".##");
    //Product product = new Product();
    //Taxes taxes = new Taxes();
    //order number, customer name, state, tax rate, product type,area, cost per square foot, 
    //labor cost per square foot,material cost, labor cost, tax, and total
    @Override
    public String toString() {
        String fullRecord;
        fullRecord = "OrderNumber: " + orderNumber + " | ";
        fullRecord = "Customer Name: " + customerName + " | ";
        fullRecord = "State :"  + state + " | ";
        fullRecord = "Tax Rate: " + taxRate + " | ";
        fullRecord = "Product Type :" + productType + " | ";
        fullRecord = "Area: " + area + " | ";
        fullRecord = "Cost per Square Foot: " + costPerSquareFoot + " | ";
        fullRecord = "Labor Cost per square fott: " + laborCostPerSquareFoot + " | ";
        fullRecord = "Material Cost: " + materialCost + " | ";
        fullRecord = "Labor Cost: " + laborCost + " | ";
        fullRecord = "Tax: " + tax + " | ";
        fullRecord = "Total: " + total ;
        return fullRecord;
    }
    //order number, customer name, state, tax rate, product type,area, cost per square foot, 
    //labor cost per square foot,material cost, labor cost, tax, and total
    public void setOrderNumber(int orderNumber) {   this.orderNumber = orderNumber; }
    public void setCustomerName(String customerName) {  this.customerName = customerName;   }
    public void setState(String state) {    this.state = state; }
    public void setTaxRate(double taxRate) {    this.taxRate = taxRate; }
    public void setProductType(String productType) {    this.productType = productType; }
    public void setArea(double area) {  this.area = area;   }
    public void setCostPerSquareFoot(double costPerSquareFoot) {    
        this.costPerSquareFoot = costPerSquareFoot; }
    public void setLaborCostPerSquareFoot(double laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;   }
    
    public void setMaterialCost() {
        this.materialCost = this.area * this.costPerSquareFoot; 
        this.materialCost = Double.parseDouble(df2.format(this.materialCost));
        System.out.println("material cose=" + this.area + " * " + this.costPerSquareFoot + " = " + this.materialCost);
        }
    public void setLaborCost() {
        this.laborCost = this.area * this.laborCostPerSquareFoot;
        this.laborCost = Double.parseDouble(df2.format(this.laborCost)); }
    public void setTax() {
        this.tax = this.taxRate * 0.01 * (this.materialCost + this.laborCost); 
        this.tax = Double.parseDouble(df2.format(this.tax)); }
    public void setTotal() {
        this.total = this.materialCost + this.laborCost + this.tax ;
        this.total = Double.parseDouble(df2.format(this.total)) ;}
    
    public Order(){ }
    public Order(int orderNumber) { this.orderNumber = orderNumber; }
    public int getOrderNumber() {   return orderNumber; }
    public String getCustomerName() {   return customerName;    }
    public String getState() {  return state;   }
    public double getTaxRate() {    return taxRate; }
    public String getProductType() {    return productType; }
    public double getArea() {   return area;    }
    public double getCostPerSquareFoot() {  return costPerSquareFoot;   }    
    public double getLaborCostPerSquareFoot() { return laborCostPerSquareFoot;  }
    public double getMaterialCost() {   return materialCost;    }
    public double getLaborCost() {  return laborCost;   }
    public double getTax() {    return tax; }
    public double getTotal() {  return total;   }
    
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
}