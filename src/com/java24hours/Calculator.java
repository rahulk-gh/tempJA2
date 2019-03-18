/*
 * To test out try catch block
we pass arugments by editing run project properties
So the error introduced is through args - example passging something non 
numerical
 */
package com.java24hours;

/**
 *
 * @author rahulk-gh
 */
public class Calculator {
    public static void main(String[] args){
        float sum = 0;
        for (String arg : args){
            try{
                sum = sum+ Float.parseFloat(arg);
            }catch(NumberFormatException e){
                System.out.println(arg + " is not a number.");
            }
        }
        System.out.println("Those numbers ccc add upto "+ sum);
    }
}
