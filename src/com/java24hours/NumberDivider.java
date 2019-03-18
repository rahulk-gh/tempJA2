/*
To test multiple exceptions
 */
package com.java24hours;

/**
 *
 * @author Rahulk-gh
 */
public class NumberDivider {
    public static void main(String[] args){
        if (args.length==2){
            int result = 0;
            try{
                result = Integer.parseInt(args[0])/Integer.parseInt(args[1]);
                System.out.println("first argument divided by the second ar"
                        + "gument is "+ result);
            } catch (NumberFormatException exc){
                System.out.println("Both arguments should be numbers");
            }catch(ArithmeticException exc) {
                System.out.println("cannot divide in that manner");
                //in another example we would add a line "throw exc;"
                //but there is more..
            }
        }
    }
}
