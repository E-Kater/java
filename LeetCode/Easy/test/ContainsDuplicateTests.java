import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTests {

    @Test
    public void ContainsDuplicateTest1() {
        // assert statements
        assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1,2,1}), "121 contains duplicates,  should be true");
    }


    @Test
    public void ContainsDuplicateTest2() {
        // assert statements
        assertFalse(ContainsDuplicate.containsDuplicate(new int[]{1,2,3}), "123 does not contain duplicates,  should be false");
    }
}
