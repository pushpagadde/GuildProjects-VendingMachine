/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapes;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class MasterShapeMethod {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String shape;
        double length, width;
        
        Square square = new Square();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        
        System.out.println("Enter the shape");
        shape = sc.next();
        
        if (shape.equalsIgnoreCase("Square")) {
            System.out.println("Enter the length of a side of the square");
            length = sc.nextDouble();
            square.setLength(length);
            System.out.println("The length of the square is " + length);
            System.out.println("Area of square is " + square.area() );
            System.out.println("Perimeter of square is " + square.perimeter());
            
        } else if (shape.equalsIgnoreCase("circle")){
            System.out.println("Enter the radius of the circle");
            length = sc.nextDouble();
            //square.setLength(length);
            System.out.println("The length of the radius is " + length);
            System.out.println("Area of square is " + circle.area(length) );
            System.out.println("Perimeter of square is " + circle.perimeter(length));
            
                        
        } else if (shape.equalsIgnoreCase("rectangle")){
            System.out.println("Enter the length of a side of the rectangle");
            length = sc.nextDouble();
            rectangle.setLength(length);
            System.out.println("Enter the width of a side of the rectangle");
            length = sc.nextDouble();
            rectangle.setWidth(length);
            
            System.out.println("The length of the rectangle is " + rectangle.getLength());
            System.out.println("The width of the rectangle is " + rectangle.getWidth());
            
            System.out.println("Area of rectangle is " + rectangle.area() );
            System.out.println("Perimeter of rectangle is " + rectangle.perimeter());
            
        } else if (shape.equalsIgnoreCase("triangle")) {
            
            System.out.println("Enter the base of the triangle");
            length = sc.nextDouble();
            triangle.setBase(length);
            
            System.out.println("Enter the height of the triangle");
            length = sc.nextDouble();
            triangle.setHeight(length);
            
            System.out.println("Enter the side of the triangle");
            length = sc.nextDouble();
            triangle.setSide1(length);
            
            System.out.println("Enter the 2nd side of the triangle");
            length = sc.nextDouble();
            triangle.setSide2(length);
            
            System.out.println("Enter the 3rd side of the triangle");
            length = sc.nextDouble();
            triangle.setSide3(length);
            
            System.out.println("The base of the triangle is " + triangle.getBase());
            System.out.println("The height of the triangle is " + triangle.getHeight());
            System.out.println("The length of sides of the triangle are " + triangle.getSide1() + ", " + triangle.getSide2() + ", " + triangle.getSide3());
            
            
            System.out.println("Area of triangle is " + triangle.area() );
            System.out.println("Perimeter of triangle is " + triangle.perimeter());
            
        } else {
            
            System.out.println("You did not enter square/circle/rectangle/triangle.");
        }
            
    }
}
