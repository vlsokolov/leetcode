package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

    public static int calculateSubstring(String s) {
        char[] chars = s.toCharArray();

        if(s.length() <= 1) return s.length();

        int left = 0;
        int maxSubstring = 0;
        Map<Character, Integer> charsWithPosition = new HashMap<>();

        for (int right = 0; right < chars.length; right++) {
            char currentChar = chars[right];
            if (charsWithPosition.containsKey(currentChar)) {
                int seenChar = charsWithPosition.get(currentChar);
                if (seenChar >= left) {
                    left = seenChar + 1;
                }
            }
            charsWithPosition.put(currentChar, right);
            maxSubstring = Math.max(maxSubstring, right - left + 1);
        }

        return maxSubstring;
    }

    public static void main(String[] args) {
        String s = "abcbdaac";
        String s1 = "aaaaa";
        String s2 = "au";
        System.out.println(calculateSubstring(s));
        System.out.println(calculateSubstring(s1));
        System.out.println(calculateSubstring(s2));
    }
}
