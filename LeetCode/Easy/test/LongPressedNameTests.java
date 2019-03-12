import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LongPressedNameTests {

    @Test
    public void LongPressedNameTest1() {
        // assert statements
        assertTrue(LongPressedName.isLongPressedName("alex", "aaleex"), "LongPressedName.isLongPressedName( \"alex\",\"aaleex\") should be true");
    }
        @Test
        public void LongPressedNameTests2() {
            // assert statements
            assertFalse(LongPressedName.isLongPressedName("saeed", "ssaaedd"), "LongPressedName.isLongPressedName( \"saeed\",\"ssaaedd\") should be false");
        }


    @Test
    public void LongPressedNameTest3() {
        // assert statements
        assertTrue(LongPressedName.isLongPressedName("leelee", "lleeelee"), "LongPressedName.isLongPressedName( \"leelee\",\"lleeelee\") should be true");
    }



    @Test
    public void LongPressedNameTest4() {
        // assert statements
        assertTrue(LongPressedName.isLongPressedName("laiden", "laiden"), "LongPressedName.isLongPressedName( \"laiden\",\"laiden\") should be true");
    }

    @Test
    public void LongPressedNameTest5() {
        // assert statements
        assertFalse(LongPressedName.isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"), "LongPressedName.isLongPressedName( \"kikcxmvzi\",\"kiikcxxmmvvzz\") should be false");
    }



    }

