import java.util.Arrays;
import java.util.stream.Collectors;

public class Sorting {

    public static int[] BubbleSort(int[] array){
        if(array.length != 0) {
            int tempElement;
            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < array.length - i - 1; j++) {
                    if(array[j] > array[j+1]){
                        tempElement = array[j];
                        array[j] = array[j+1];
                        array[j+1] = tempElement;

                    }
                }
        }
           return array;
    }

    public static String getArrayAsString(int[] arr){
       return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
