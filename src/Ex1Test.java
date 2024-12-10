/********************/
/********************/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2", "3 b4"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        String s1 = Ex1.int2Number(1211,16);
        String s2 = "4BBbG";
        assertEquals(s2,s1);
        String s3 = Ex1.int2Number(90804, 8);
        assertEquals(s3,"261264b8");
    }
    @Test
    void maxIndexTest() {
        String[] arr = {"111b2" , "10", "17", "70"};
        int ans = Ex1.maxIndex(arr);
        assertEquals(ans, 70);
        String[] arr1 = {"100b5" , "AbG", "35", "250"};
        int ans2 = Ex1.maxIndex(arr1);
        assertEquals(ans2, 250);

    }

    @org.junit.jupiter.api.Test
    void number2Int() {
        String s1 = "666324b7";
        int v = Ex1.number2Int(s1);
        assertEquals(v,117471);
    }
}
