import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumberTests {

    @Test
    public void HappyNumberTests1() {
        // assert statements
        assertTrue(HappyNumber.isHappy(19), "19 is a happy number,  should be true");
    }


    @Test
    public void HappyNumberTests2() {
        // assert statements
        assertFalse(HappyNumber.isHappy(999), "999 is not happy number,  should be false");
    }

    @Test
    public void HappyNumberTests3() {
        // assert statements
        assertTrue(HappyNumber.isHappy(31), "31 is a happy number,  should be true");
    }


    @Test
    public void HappyNumberTests4() {
        // assert statements
        assertFalse(HappyNumber.isHappy(12), "12 is not happy number,  should be false");
    }

    @Test
    public void HappyNumberTests5() {
        // assert statements
        assertTrue(HappyNumber.isHappy(13), "13 is a happy number,  should be true");
    }
}
