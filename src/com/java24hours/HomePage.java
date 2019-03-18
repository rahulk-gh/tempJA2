/*
 * To test catching and throwing exceptions between classes.
 look for homepage.java and pagecatalog.java for the full functionality
 */
package com.java24hours;
import java.net.*;


/**
 *
 * @author RahulK-gh
 */
public class HomePage {
    String owner;
    URL address; //seems to be a class in the .net package
    String category = "none";
    
    public HomePage (String inOwner, String inAddress)
            throws MalformedURLException{
        //pay attention to the formating of the throws statement
        owner = inOwner;
        address = new URL(inAddress);
    }
    
    public HomePage(String inOwner, String inAddress, String inCategory)
            throws MalformedURLException{
        this(inOwner, inAddress);
        category = inCategory;
    }
}   
