package my.test;
import lab5.subtitle.MyException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

public class ATests {
  /*  @Test(expected = Err.class)
    public void throwsMyException() throws Err {

        A a = new A(8);

    }*/


    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test public void Tes() throws Err{
        thrown.expect(Err.class);
       // thrown.expectMessage("chuj");
        A a=new A(362);

    }
    @Test public void throwsMyExceptionWhenAIsCreatedWithNull()throws Err {
        try {
            A a = new A(269);
            fail("Expected MyException to be thrown");
        } catch( Err ex ) {
            //do some checks with ex

        }
    }
}