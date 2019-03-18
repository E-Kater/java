/** 234
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
    if(fast != null){
        slow = slow.next;
    }

    slow = reverse(slow);
    fast = head;

    while (slow != null){
        if(fast.val != slow.val){
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
      /*  StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(String.valueOf(head.val));
            head = head.next;
        }
        return sb.toString().equals(sb.reverse().toString()); -129,-129 failed!!*/

    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    return prev;
    }


}

