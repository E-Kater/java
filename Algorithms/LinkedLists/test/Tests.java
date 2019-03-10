import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Tests {

    @Test
    public void getMyListAsStringTest() {
        MyList<Integer> tester = new MyList<>(1);
        MyList<Integer> next = new MyList<>(2);
        MyList<Integer> last = null;
        next.setNext(last);
        tester.setNext(next);

        // assert statements
        assertEquals("12", tester.getListAsString(), "tester.getDate() must be 12");
    }

    @Test
    public void InsertIntoFrontTest() {
        MyList<Integer> tester = new MyList<>(1);
        MyList<Integer> next = new MyList<>(2);
        tester.setNext(next);
      // MyList<Integer> l =
       MyList<Integer> l =  tester.insertInFront( 5);

        // assert statements
        assertEquals("512", l.getListAsString(), "tester.InsertIntoFrontTest must be 512");
    }


    @Test
    public void InsertIntoEndTest() {
        MyList<Integer> tester = new MyList<>(1);
        MyList<Integer> next = new MyList<>(2);
        tester.setNext(next);
        // MyList<Integer> l =
        MyList<Integer> l =  tester.insertInEnd( 5);

        // assert statements
        assertEquals("125", l.getListAsString(), "tester.InsertIntoEndTest must be 125");

    }

        @Test
    public void creationOfMyListTest() {
        MyList<Integer> tester = new MyList<>(1);
        MyList<Integer> next = new MyList<>(2);
        MyList<Integer> last = null;
        next.setNext(last);
        tester.setNext(next);

        // assert statements
        assertEquals(1, tester.getData(), "tester.getDate() must be 1");
    }


    @Test
    public void creationOfMyListTestFindFalse() {
        MyList<Integer> tester = new MyList<>(1);
        MyList<Integer> next = new MyList<>(2);
        tester.setNext(next);

        // assert statements

        assertNull(tester.find(tester, 10), "tester MyList does not contain 10");
    }


    @Test
    public void creationOfMyListTestFindTrue() {
        MyList<Integer> tester = new MyList<>(1);
        MyList<Integer> next = new MyList<>(2);
        tester.setNext(next);


        assertEquals(next, tester.find(tester, 2), "tester MyList contains element 2");
    }
}
