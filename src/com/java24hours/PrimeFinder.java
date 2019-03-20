/*
 * This class demos
 */

package com.java24hours;

/**
 *
 * @author rahulk-gh
 */
public class PrimeFinder implements Runnable {
    //Runnable interface applied above
    Thread go;// a Thread object call go is created..but no assignment yet
    StringBuffer primes = new StringBuffer();//what is a stringbuffer?
    int time=0;
    
    public PrimeFinder () {
        start();//one of the steps needed to run the thread
        while (primes != null){
            System.out.println(time);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException exc){
                //do nothing
            }
            time++;
        }
    }
    
    public void start(){
        //if this new go object variable has a value of null, which indicates
        //the thread hasnt been created yet,then new Thread object is created
        //and stored in variable
        if (go == null) {
            go = new Thread(this);//splitting up the constructor??
            go.start();
        }
    }
    
    public void run(){
        int quantity = 1_000_000;
        int numPrimes = 0;
        //candidate : the number that might be prime
        int candidate = 2;
        primes.append("\nFirst ").append(quantity).append(" primes:\n\n");
        while (numPrimes < quantity){
            if (isPrime (candidate)){
                primes.append(candidate).append(" ");
                numPrimes++;
            }
            candidate++;
        }
        System.out.println(primes);
        primes = null;
        System.out.println("\nTime elapsed: "+ time + " seconds");
    }
    
    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i =2; i <= root; i++) {
            if (checkNumber % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        new PrimeFinder();
    }
            
    
}


