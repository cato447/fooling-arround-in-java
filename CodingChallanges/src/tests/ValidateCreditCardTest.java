package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import numbers.ValidateCreditCard;

public class ValidateCreditCardTest {
    @Test
    public void test1() {
        assertEquals(false, ValidateCreditCard.validateCard(79927398714L));
    }

    @Test
    public void test2() {
        System.out.println("Passes Luhn test, but too short.");
        assertEquals(false, ValidateCreditCard.validateCard(79927398713L));
    }

    @Test
    public void test3() {
        assertEquals(true, ValidateCreditCard.validateCard(709092739800713L));
    }

    @Test
    public void test4() {
        assertEquals(false, ValidateCreditCard.validateCard(1234567890123456L));
    }

    @Test
    public void test5() {
        assertEquals(true, ValidateCreditCard.validateCard(12345678901237L));
    }

    @Test
    public void test6() {
        assertEquals(true, ValidateCreditCard.validateCard(5496683867445267L));
    }

    @Test
    public void test7() {
        assertEquals(false, ValidateCreditCard.validateCard(4508793361140566L));
    }

    @Test
    public void test8() {
        assertEquals(true, ValidateCreditCard.validateCard(376785877526048L));
    }

    @Test
    public void test9() {
        assertEquals(false, ValidateCreditCard.validateCard(36717601781975L));
    }
}