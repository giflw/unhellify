package com.itquasar.unhellify.unnullify;

import static com.itquasar.unhellify.unnullify.Option.None;
import static com.itquasar.unhellify.unnullify.Option.Some;
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
public class OptionNGTest {

    /**
     * Test of None constant, of class Option.
     */
    @Test()
    public void testNone() {
        Assert.assertEquals(None, None); // test comparissom using equals, that must be true
        Assert.assertSame(None, None); // test comparissom using ==, that must be true
        Assert.assertFalse(None.hasValue()); // test hasValue, that must be false
    }

    /**
     * Test of getValue from None constant, of class Option, that must throw
     * NoValueError.
     */
    @Test(expectedExceptions = {NoValueError.class})
    public void testNoneError() {
        None.getValue(); // test getValue, as it must throws an Error, as annotated on method
    }

    /**
     * Test of Some method, of class Option.
     */
    @Test()
    public void testSome() {
        String val1 = "foo bar";
        String val2 = "bar foo";
        Some<String> some1 = Some(val1);
        Some<String> some1_2 = Some(val1);
        Some<String> some2 = Some(val2);

        // test hasValue
        Assert.assertTrue(some1.hasValue());
        Assert.assertTrue(some2.hasValue());
        // test getValue
        Assert.assertEquals(val1, some1.getValue());
        Assert.assertEquals(val2, some2.getValue());

        // test comparisson using equals
        Assert.assertEquals(some1, some1_2);
        Assert.assertNotEquals(some1, some2);
    }

    /**
     * Test of constructor for Some, that must throw NullValueError for.
     */
    @Test(expectedExceptions = {NullValueError.class})
    public void testSomeError() {
        // test constructur with null
        Some(null);
    }

}
