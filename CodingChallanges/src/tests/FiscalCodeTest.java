package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import strings.FiscalCode;

/**
 * @author edwardclark
 **/

public class FiscalCodeTest {
    @Test
    public void test1() throws Exception {
        assertEquals("CHEBND61T01", FiscalCode.fiscalCode("Brendan", "Eich", "M", "1/12/1961"));
    }

    @Test
    public void test2() throws Exception {
        assertEquals("YUXHLN50T41", FiscalCode.fiscalCode("Helen", "Yu", "F", "1/12/1950"));
    }

    @Test
    public void test3() throws Exception {
        assertEquals("CPNLAX99A17", FiscalCode.fiscalCode("Al", "Capone", "M", "17/1/1899"));
    }

    @Test
    public void test4() throws Exception {
        assertEquals("MSOMKY28A16", FiscalCode.fiscalCode("Mickey", "Mouse", "M", "16/1/1928"));
    }

    @Test
    public void test5() throws Exception {
        assertEquals("CRUMRA67S47", FiscalCode.fiscalCode("Marie", "Curie", "F", "7/11/1867"));
    }
}