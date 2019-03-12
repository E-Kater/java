/*
* Your friend is typing his name into a keyboard.
* Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.
Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.


Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.

* */

import javax.swing.event.ChangeEvent;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;
        if (name.charAt(0) != typed.charAt(0)) return false;
        if (name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) return false;

        int indx = 0;
        for (char typedChar : typed.toCharArray()) {
            if (indx < name.length()) {
                if (typedChar != name.charAt(indx)) {
                    if (typedChar != name.charAt(indx - 1)) {
                        return false;
                    }
                } else {
                    indx++;
                }
            } else {
                if (typedChar != name.charAt(indx - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

        /*
       failed:
    @Test
    public void LongPressedNameTest5() {
        // assert statements
        assertFalse(LongPressedName.isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"), "LongPressedName.isLongPressedName( \"kikcxmvzi\",\"kiikcxxmmvvzz\") should be false");
    }
       Map<Integer, Integer> mapName = occurenSymbolsMap(name);
        Map<Integer, Integer> typedName = occurenSymbolsMap(typed);
        Integer currInt;
        for(Integer c: mapName.keySet()){
            currInt = typedName.get(c);
            if(currInt == null) return false;
            if(currInt < mapName.get(c)) return false;
        }
        return true;
    }

    public static Map<Integer, Integer> occurenSymbolsMap(String s){
        Map<Integer, Integer> map = new HashMap<>();
        s.chars().forEach(c -> {
            Integer n = map.get(c);
            if (n ==  null) n = 0;
            map.put(c, n+1);
        } );
        return map;
    }*/


}

