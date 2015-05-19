package com.itquasar.unhellify.unnullify;

import static com.itquasar.unhellify.unnullify.Result.Err;
import static com.itquasar.unhellify.unnullify.Result.Ok;
import com.itquasar.unhellify.unnullify.exceptions.NoErrorError;
import com.itquasar.unhellify.unnullify.exceptions.NoValueError;
import com.itquasar.unhellify.unnullify.exceptions.NullValueError;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 *
 */
public class ResultNGTest {

    /**
     * Test of Err method, of class Result.
     */
    @Test()
    public void testErr() {
        String val1 = "Foo bar";
        String val2 = "Bar foo";
        Result<String, String> err1 = Err(val1);
        Result<String, String> err1_2 = Err(val1);
        Result<String, String> err2 = Err(val2);

        // test hasValue
        Assert.assertFalse(err1.hasValue());
        Assert.assertFalse(err2.hasValue());
        // test getError
        Assert.assertEquals(val1, err1.getError());
        Assert.assertEquals(val2, err2.getError());

        // test comparisson using equals
        Assert.assertEquals(err1, err1_2);
        Assert.assertNotEquals(err1, err2);
    }

    /**
     * Test of getValue from Err, that must throw NoValueError.
     */
    @Test(expectedExceptions = {NoValueError.class})
    public void testErrGetValueError() {
        Err("bla").getValue(); // test getValue, as it must throws an Error, as annotated on method
    }

    /**
     * Test of constructor for Err, that must throw NullValueError for.
     */
    @Test(expectedExceptions = {NullValueError.class})
    public void testErrNullError() {
        Err(null); // test constructur with null
    }

    /**
     * Test of Ok method, of class Result.
     */
    @Test()
    public void testSome() {
        String val1 = "foo bar";
        String val2 = "bar foo";
        Result<String, String> ok1 = Ok(val1);
        Result<String, String> ok1_2 = Ok(val1);
        Result<String, String> ok2 = Ok(val2);

        // test hasValue
        Assert.assertTrue(ok1.hasValue());
        Assert.assertTrue(ok2.hasValue());
        // test getValue
        Assert.assertEquals(val1, ok1.getValue());
        Assert.assertEquals(val2, ok2.getValue());

        // test comparisson using equals
        Assert.assertEquals(ok1, ok1_2);
        Assert.assertNotEquals(ok1, ok2);
    }

    /**
     * Test of getError from Ok, that must throw NoErrorError.
     */
    @Test(expectedExceptions = {NoErrorError.class})
    public void testOkGetErrorError() {
        Ok("bla").getError(); // test getError, as it must throws an Error, as annotated on method
    }

    
     /**
     * Test of constructor for Err, that must throw NullValueError for.
     */
    @Test(expectedExceptions = {NullValueError.class})
    public void testOkNullError() {
        Ok(null); // test constructur with null
    }
}
