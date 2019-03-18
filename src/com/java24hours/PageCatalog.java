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
public class PageCatalog {
    public static void main(String[] args){
        HomePage[] catalog = new HomePage[5];
        
        try{
            catalog[0] = new HomePage("Mike Glyer", "http://www.file770.com",
            "science fiction");
            catalog[1] = new HomePage("Shelly p", "http://www.burningbird.net",
            "environment");
            catalog[2] = new HomePage("Roger C", "http://workbench.cadenhead.org",
             "Porgamming");
            catalog[3] = new HomePage("Taegan g", "https://politicalwire.com", 
            "politics");
            catalog[4] = new HomePage("Manton R", "http://www.manton.org");
            
            for (int i = 0; i < catalog.length; i++){
                System.out.println(catalog[i].owner + ": "+
                        catalog[i].address + " -- "+
                        catalog[i].category );
            }
                    
        } catch (MalformedURLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
