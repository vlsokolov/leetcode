import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(minRemoveToMakeValid("())()((("));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();

        int openParentheses = 0;
        int charsCount = 0;
        int pairs = 0;

        for (char c : chars) {
            if (c == '(') {
                openParentheses++;
            }
            if (c == ')' && openParentheses > pairs) {
                pairs++;
            }
            if (c != '(' && c != ')') {
                charsCount++;
            }
        }

        openParentheses = 0;

        StringBuilder sb = new StringBuilder(charsCount + pairs * 2);

        for (char c : chars) {
            if (c != ')') {
                if (c == '(') {
                    if (pairs > 0) {
                        sb.append(c);
                        openParentheses++;
                        pairs--;
                    }
                } else {
                    sb.append(c);
                }
            } else {
                if (openParentheses > 0) {
                    sb.append(c);
                    openParentheses--;
                }
            }
        }

        return sb.toString();
    }
}
