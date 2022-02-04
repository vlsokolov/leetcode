package strings;

public class ValidPalindrome {

    public static boolean isValidPalindrome(String s) {
        char[] chars = s.replaceAll("[^A-Za-z0-9]","").toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (right >= left) {
            if (chars[right] != chars[left]) {
                return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right-1);
            }
            right--;
            left++;
        }

        return true;
    }

    private static boolean isPalindrome(char[] chars, int left, int right) {
        while (right >= left) {
            if (chars[right] != chars[left]) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
    }
}
