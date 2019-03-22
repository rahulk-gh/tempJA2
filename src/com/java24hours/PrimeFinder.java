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
        //why check for when prime is null (not created/ empty???)- this is 
        //because, we want to maybe
        //sync the running of some operations in the thread and once that has 
        //been started..start filling the buffer with information like time 
        //elapsed, etc
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
            //also does this mean that different threads could have the same 
            //name?
            
            go.start();
        }
    }
    
    //there is no call of run(), this happens when the threaded object is 
    //created (go) and the start method is called
    public void run(){
        int quantity = 1_000_000;
        int numPrimes = 0;
        //candidate : the number that might be prime
        int candidate = 2;
        primes.append("\nFirst ").append(quantity).append(" primes:\n\n");
        while (numPrimes < quantity){
            if (isPrime (candidate)){
                primes.append(candidate).append(" ");
                //append.append.append...this is allowed because append reaturns
                //the buffer and that can be used to be called again
                numPrimes++;
            }
            candidate++;
        }
        System.out.println(primes);
        primes = null;//why is this important?
        System.out.println("\nTime elapsed: "+ time + " seconds");
    }
    
    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i =2; i <= root; i++) {
            if (checkNumber % i == 0){
                return false;
                //should there be a break?
                //tried putting a break statement, but it is 'unreachable'
                //which suggests that if a return statement exists..the 
                //function will not execute anything further inside
            }
        }
        return true;
    }
    public static void main(String[] args){
        new PrimeFinder();
        //normally we would see something like 
        //PrimeFinder frame = new PrimeFinder();
        //but there is no reason to refer to that object again so we do what
        //is above
        
    }
            
    
}


