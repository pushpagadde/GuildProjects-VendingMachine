
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class WindowMaster {
    public static void main(String[] args) {
        float height, width;
        float areaofWindow, costofWindow, perimeterofWindow;
        String strheight, strwidth;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the Height of the window:");
        strheight = sc.nextLine();
        System.out.println("Enter the Width of the window:");
        strwidth = sc.nextLine();
        
        
        height = Float.parseFloat(strheight);
        width = Float.parseFloat(strwidth);
        
        areaofWindow = height * width;
        perimeterofWindow = 2 * ( height + width );
        costofWindow = ( 3.50f * areaofWindow) + ( 2.25f * perimeterofWindow);
        
        System.out.println("The Height of the window is:");
        System.out.println(height);
        System.out.println("The Width of the window is:");
        System.out.println(width);
        System.out.println("The area of the window is:");
        System.out.println(areaofWindow);
        System.out.println("The perimeter of the window is:");
        System.out.println(perimeterofWindow);
        System.out.println("The total cost for the window is:");
        System.out.println(costofWindow);
        
        
        
        
        
        
        
    }
    
}
