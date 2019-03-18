import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeLinkedListTests {

    @Test
    public void PalindromeLinkedListTest1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // assert statements
        assertTrue(PalindromeLinkedList.isPalindrome(head), "1->2->2->1 is a palindrome, should be true");
    }


    @Test
    public void PalindromeLinkedListTest2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // assert statements
        assertFalse(PalindromeLinkedList.isPalindrome(head), "1->2  is not a palindrome, should be false");
    }


    @Test
    public void PalindromeLinkedListTest3() {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);


        // assert statements
        assertTrue(PalindromeLinkedList.isPalindrome(head), "-129->-129 is a palindrome, should be true");
    }
}
