import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JewelsAndStonesTests {

    @Test
    public void numJewelsInStoneTest1() {
        // assert statements
        assertEquals(2, JewelsAndStones.numJewelsInStones("a", "aaAsAA"), "numJewelsInStones should be 2");
    }

    @Test
    public void numJewelsInStoneTest2() {
        // assert statements
        assertEquals(0, JewelsAndStones.numJewelsInStones("a", ""), "numJewelsInStones should be 0");
    }

    @Test
    public void numJewelsInStoneTest3() {
        // assert statements
        assertEquals(0, JewelsAndStones.numJewelsInStones("", "aaAsAA"), "numJewelsInStones should be 0");
    }

    @Test
    public void numJewelsInStoneTest4() {
        // assert statements
        assertEquals(4, JewelsAndStones.numJewelsInStones("abC", "aaAsAABbCcfdh"), "numJewelsInStones should be 4");
    }

}
