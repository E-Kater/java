import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Tests {

    @Test
    public void creationOfListTest() {
        List<Integer> tester = new List<>(1);
        List<Integer> next = new List<>(2);
        tester.setNext(next);

        // assert statements
        assertEquals(1, tester.value(), "tester.value() must be 1");
        assertNull(tester.find(tester, 10), "tester list does not contain 10");
        assertEquals(next, tester.find(tester, 2), "tester list contains element 2");
    }


    @Test
    public void creationOfListTestFindFalse() {
        List<Integer> tester = new List<>(1);
        List<Integer> next = new List<>(2);
        tester.setNext(next);

        // assert statements

        assertNull(tester.find(tester, 10), "tester list does not contain 10");
    }


    @Test
    public void creationOfListTestFindTrue() {
        List<Integer> tester = new List<>(1);
        List<Integer> next = new List<>(2);
        tester.setNext(next);


        assertEquals(next, tester.find(tester, 2), "tester list contains element 2");
    }
}
