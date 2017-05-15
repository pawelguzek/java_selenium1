package pl.guzek;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Pawel on 10.05.2017.
 */
public class PrimeTests {

    @Test
    public void testPrime(){

        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));

    }
}

