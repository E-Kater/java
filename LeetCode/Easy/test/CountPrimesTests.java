import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountPrimesTests {

    @Test
    public void CountPrimesTests1() {
        // assert statements
        assertEquals(4, CountPrimes.countPrimes(10), "There are 4 prime numbers less than 10, they are 2, 3, 5, 7, should be 4");
    }
    @Test
    public void CountPrimesTests2() {
        // assert statements
        assertEquals(2, CountPrimes.countPrimes(4), "There are 2 prime numbers less than 4, they are 2,3, should be 2");
    }
}
