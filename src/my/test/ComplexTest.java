package my.test;

import org.junit.Assert;
import org.junit.Test;

public class ComplexTest {
    final static double DELTa=1.e-15;
    @Test
    public void Test1(){
        Complex c1=new Complex(1,2);
        Complex c2= new Complex(-1,5);
        Complex r=c1.add(c2);
        Assert.assertEquals("coś tam", 4.,r.im(),DELTa);
    }
}
