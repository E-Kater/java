import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortTests {

        @Test
        public void BubbleSortTest() {
            int[] arr = new int[5];
            arr[0] = 1;
            arr[1] = -1;
            arr[2] = 5;
            arr[3] = 10;
            arr[4] = 4;

            // assert statements
            assertEquals("-114510", Sorting.getArrayAsString(Sorting.BubbleSort(arr)), "-114510 should be");
        }

}
