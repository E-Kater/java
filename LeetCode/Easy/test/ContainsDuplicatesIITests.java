import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicatesIITests {



        @Test
        public void ContainsDuplicateTestII1() {
            // assert statements
            assertTrue(ContainsDuplicateII.containsNearbyDuplicate(new int[]{1,2,3,1},3), "1231 contains duplicates,  should be true");
        }

    @Test
    public void ContainsDuplicateTestII2() {
        // assert statements
        assertTrue(ContainsDuplicateII.containsNearbyDuplicate(new int[]{1,0,1,1},1), "1011 contains duplicates,  should be true");
    }
        @Test
        public void ContainsDuplicateTestII3() {
            // assert statements
            assertFalse(ContainsDuplicateII.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2), "123123 does not contain duplicates,  should be false");
        }
    }


