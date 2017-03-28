package pl.guzek;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by Fru.pl on 27.03.2017.
 */
public class SquareTests {


    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);

    }

}
