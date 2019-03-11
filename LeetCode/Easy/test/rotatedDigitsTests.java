import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class rotatedDigitsTests {

    @Test
    public void rotatedDigitsTestsTest1() {
        // assert statements
        assertEquals(4, RotatedDigits.rotatedDigits(10), "rotatedDigitsTests should be 4");
    }

    @Test
    public void rotatedDigitsTestsTest2() {
        // assert statements
        assertEquals(0, RotatedDigits.rotatedDigits(1), "rotatedDigitsTests should be 0");
    }

    @Test
    public void rotatedDigitsTestsTest3() {
        // assert statements
        assertEquals(1, RotatedDigits.rotatedDigits(2), "rotatedDigitsTests should be 1");
    }

    @Test
    public void rotatedDigitsTestsTest4() {
        // assert statements
        assertEquals(4, RotatedDigits.rotatedDigits(11), "rotatedDigitsTests should be 4");
    }
    @Test
    public void rotatedDigitsTestsTest5() {
        // assert statements
        assertEquals(5, RotatedDigits.rotatedDigits(12), "rotatedDigitsTests should be 5");
    }

    @Test
    public void rotatedDigitsTestsTest6() {
        // assert statements
        assertEquals(247, RotatedDigits.rotatedDigits(857), "rotatedDigitsTests should be 247");
    }

}
