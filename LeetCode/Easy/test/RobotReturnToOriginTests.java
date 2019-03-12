import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotReturnToOriginTests {


    @Test
    public void RobotReturnToOriginTest1() {
        // assert statements
        assertTrue(RobotReturnToOrigin.judgeCircle("UD"), "judgeCircle should be true");
    }

    @Test
    public void RobotReturnToOriginTest2() {
        // assert statements
        assertFalse(RobotReturnToOrigin.judgeCircle("LL") ,"judgeCircle should be false");
    }
}
