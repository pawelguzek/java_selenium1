package pl.guzek;

/**
 * Created by Pawel on 10.05.2017.
 */
public class Primes {

 public static boolean isPrime(int n){
     for(int i = 2; i<n ; i++){
         if(n%i == 0){
             return false;
         }

     }
     return true;
 }

}
