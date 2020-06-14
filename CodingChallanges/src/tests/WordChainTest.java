package tests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import strings.WordChain;

public class WordChainTest {
    @Test
    public void test1() {
        assertEquals(true, WordChain.isWordChain(new String[]{"row", "crow", "crown", "brown", "brawn"}));
    }

    @Test
    public void test2() {
        assertEquals(true, WordChain.isWordChain(new String[]{"flew", "flaw", "flan", "flat", "fat", "rat", "rot", "tot"}));
    }

    @Test
    public void test3() {
        assertEquals(false, WordChain.isWordChain(new String[]{"meek", "meet", "meat", "teal"}));
    }

    @Test
    public void test4() {
        assertEquals(false, WordChain.isWordChain(new String[]{"run", "runny", "bunny"}));
    }

    @Test
    public void test5() {
        assertEquals(true, WordChain.isWordChain(new String[]{"fun", "fund", "find", "bind", "wind", "wild", "wile", "wiles"}));
    }

    @Test
    public void test6() {
        assertEquals(true, WordChain.isWordChain(new String[]{"nut", "but", "bot", "boot", "loot", "look", "book", "brook"}));
    }

    @Test
    public void test7() {
        assertEquals(true, WordChain.isWordChain(new String[]{"some", "tome", "tame", "lame", "flame", "flamer", "blamer", "blamers"}));
    }

    @Test
    public void test8() {
        assertEquals(false, WordChain.isWordChain(new String[]{"a", "at", "hat", "that", "what", "flat"}));
    }

    @Test
    public void test9() {
        assertEquals(false, WordChain.isWordChain(new String[]{"link", "blink", "wink", "sink"}));
    }
}