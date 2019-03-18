import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeNumberTests {

    @Test
    public void PalindromeNumberTest1() {
        // assert statements
        assertTrue(PalindromeNumber.isPalindrome(121), "121 is palindrome,  should be true");
    }

    @Test
    public void PalindromeNumberTest2() {
        // assert statements
        assertTrue(PalindromeNumber.isPalindrome(1215121), "1215121 is palindrome,  should be true");
    }

    @Test
    public void PalindromeNumberTest3() {
        // assert statements
        assertFalse(PalindromeNumber.isPalindrome(-121), "-121 is not  palindrome,  should be false");
    }
}
