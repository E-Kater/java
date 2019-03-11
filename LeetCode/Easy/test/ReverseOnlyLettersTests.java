import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseOnlyLettersTests {


    @Test
    public void rotatedDigitsTestsTest1() {
        // assert statements
        assertEquals("dc-ba", ReverseOnlyLetters.reverseOnlyLetters("ab-cd"), "rotatedDigitsTests should be ab-cd");
    }

    @Test
    public void rotatedDigitsTestsTest2() {
        // assert statements
        assertEquals("j-Ih-gfE-dCba", ReverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"), "\"a-bC-dEf-ghIj\" rotatedDigitsTests should be \"j-Ih-gfE-dCba\"");
    }

    @Test
    public void rotatedDigitsTestsTest3() {
        // assert statements
        assertEquals("Qedo1ct-eeLg=ntse-T!", ReverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"), "\"Test1ng-Leet=code-Q! rotatedDigitsTests should be \"Qedo1ct-eeLg=ntse-T!\"");
    }


    @Test
    public void rotatedDigitsTestsTest5() {
        // assert statements
        assertEquals("1234567890,./;-!@#$%^&*()_+'[]", ReverseOnlyLetters.reverseOnlyLetters("1234567890,./;-!@#$%^&*()_+'[]"), "\"1234567890,./;-!@#$%^&*()_+'[] rotatedDigitsTests should be 1234567890,./;-!@#$%^&*()_+'[]");
    }


}
