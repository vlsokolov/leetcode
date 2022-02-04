package stack;

import java.util.Arrays;
import java.util.Stack;

public class MinimumToRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                indexes.push(i);
            } else if (chars[i] == ')' && !indexes.isEmpty()) {
                indexes.pop();
            } else if (chars[i] == ')') {
                chars[i] = ' ';
            }
        }

        while (!indexes.isEmpty()) {
            chars[indexes.pop()] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (Character w: chars) {
            sb.append(w);
        }

//        return Arrays.stream(chars).reduce(String::concat).orElse("");
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
