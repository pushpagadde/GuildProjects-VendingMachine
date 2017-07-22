/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodeling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class LibraryCatalogueSystem {
    String nameOfBook, bookID, nameOfAuthor;
    int numberOfCopies;
    int checkedOutCopies;
    
    //constructor to initialize values
    public LibraryCatalogueSystem(String name, String id, String author, int copies) {
        this.nameOfBook = name;
        this.bookID = id;
        this.nameOfAuthor = author;
        this.numberOfCopies = copies;
        this.checkedOutCopies = 0;
    }
    
    //get and set methods to initialize and return values
    public void setNameOfBook(String name) {
        this.nameOfBook = name;
    }
    public String getNameOfBook() {
        return nameOfBook;
    }
    
    public void setNameOfAuthor(String author) {
        this.nameOfAuthor = author;
    }
    public String getNameOfAuthor() {
        return nameOfAuthor;
    }
    
    public void setBookID(String id) {
        this.bookID = id;
    }
    public String getBookID() {
        return bookID;
    }
    
    public void setNumberOfCopies(int copies) {
        this.numberOfCopies = copies;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    private void setCheckedOutCopies(int checkedOutCopies) {
        this.checkedOutCopies = checkedOutCopies;
    }

    private int getCheckedOutCopies() {
        return checkedOutCopies;
    }
    
    public boolean checkOutBook(){
        if (numberOfCopies > checkedOutCopies){
            this.setCheckedOutCopies(checkedOutCopies + 1);
            return true;
        } 
        return false;
    }
    
    public boolean checkInBook(){
        if (numberOfCopies > checkedOutCopies && checkedOutCopies > 0){
            this.setCheckedOutCopies(checkedOutCopies - 1);
            return true;
        } 
        return false;
    }
    
    public static void main(String[] args) {
      List catalogue = new ArrayList();
      LibraryCatalogueSystem book1 = new LibraryCatalogueSystem("Book1", "BOOK1", "BookOneAuthor", 5);
      catalogue.add(book1);
      System.out.println(book1.checkOutBook());
      System.out.println(book1.checkOutBook());
      System.out.println(book1.checkOutBook());
      System.out.println(book1.checkOutBook());
    }
}
