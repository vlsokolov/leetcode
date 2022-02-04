package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
       Map<Character, Character> brackets= new HashMap<Character, Character>(3){{
           put('(', ')');
           put('{', '}');
           put('[', ']');
       }};

       Stack<Character> stack = new Stack<>();

       for (Character character: s.toCharArray()) {
           if (brackets.containsKey(character)) {
               stack.push(character);
           } else if (stack.isEmpty()){
               return false;
           } else if (brackets.get(stack.pop()) != character) {
               return false;
           }
       }

       return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
    }
}
