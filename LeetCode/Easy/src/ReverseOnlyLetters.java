/*
Given a string S, return the "reversed" string where all
 characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "*/

import java.util.Arrays;

public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        int right = S.length()-1;
        int left = 0;
        char[] res = S.toCharArray();

        while (left < right){
            char leftSymb = S.charAt(left);
            while (!Character.isLetter(leftSymb) && left < right){
                leftSymb = S.charAt(++left);
            }

            char rightSymb = S.charAt(right);
            while (!Character.isLetter(rightSymb) && left < right){
                rightSymb = S.charAt(--right);
            }
            res[left] = S.charAt(right);
            res[right] = S.charAt(left);

            left++;
            right--;

        }

       return new String(res);

    }

}
