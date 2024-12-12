
package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */

public class Ex1Test {
    @Test
    void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void isNumberTest() {

            assertFalse(Ex1.isNumber("-1B1"));//הפעולה משווה אם הערך אמת == הפןנגצה עובדת טוב
            assertFalse(Ex1.isNumber(null));
            assertFalse(Ex1.isNumber("123b2"));
            assertFalse(Ex1.isNumber("1n"));
            assertFalse(Ex1.isNumber("3T"));
            assertFalse(Ex1.isNumber(""));
            assertFalse(Ex1.isNumber("10 11b2"));
            assertFalse(Ex1.isNumber("1234b10"));
            assertFalse(Ex1.isNumber("3b3"));
            assertFalse(Ex1.isNumber("-3b5"));
            assertFalse(Ex1.isNumber("3 b4"));
            assertFalse(Ex1.isNumber("GbG"));
            assertTrue(Ex1.isNumber("123b5"));
            assertTrue(Ex1.isNumber("135"));
            assertTrue(Ex1.isNumber("100111b2"));
            assertTrue(Ex1.isNumber("12345b6"));
            assertTrue(Ex1.isNumber("012b5"));
            assertTrue(Ex1.isNumber("123bG"));
            assertTrue(Ex1.isNumber("EFbG"));


    }
    @Test
    void number2Int(){
        assertEquals(3,Ex1.number2Int("11b2"));
        assertEquals(43,Ex1.number2Int("101011b2"));
        assertEquals(1380,Ex1.number2Int("2544b8"));
        assertEquals(1932,Ex1.number2Int("78CbG"));
        assertEquals(27,Ex1.number2Int("123b4"));
        assertEquals(13,Ex1.number2Int("13bA"));
        assertEquals(36,Ex1.number2Int("36bA"));

    }
    @Test
    void maxIndexTest() {
       String[]arr1={"1001b2","36","13","11b3"};
       assertEquals(2,Ex1.maxIndex(arr1));
        String[]arr2={"223b5","1010b2","8","56b9"};
        assertEquals(3,Ex1.maxIndex(arr2));
        String[]arr3={"12bA","1011b2","56bG","13b8"};
        assertEquals(2,Ex1.maxIndex(arr3));
    }
    @Test
    void in2NumberTest() {
        assertEquals("1011b2", Ex1.int2Number(11,2));
        assertEquals("101b2", Ex1.int2Number(5,2));
        assertEquals("9CbG", Ex1.int2Number(156,16));
        assertEquals("3b9", Ex1.int2Number(3,9));
        assertEquals("", Ex1.int2Number(8,22));


    }
    }
