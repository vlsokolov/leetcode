package strings;

public class AlmostPalindrome {

    public static boolean isAlmostPalindrome(String s) {
        char[] chars = s.replaceAll("[^A-Za-z0-9]","").toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        int leftTry = 0;
        int rightTry = 0;
        int tryCounter = 0;

        while (right > left) {
            if (chars[right] != chars[left]) {
                if (tryCounter <=1) {
                    if (tryCounter == 0) {
                        leftTry = left;
                        rightTry = right;
                        left++;
                    } else {
                        left = leftTry;
                        right = rightTry - 1;
                    }
                    tryCounter++;
                    continue;
                } else {
                    return false;
                }
            }
            right--;
            left++;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        String s1 = "abccdba";
        String s2 = "abcdefdba";
        String s3 = "";
        String s4 = "a";
        String s5 = "ab";
        String s6 = "abc";
        String s7 = "eedede";
        String s8 = "ececabbacec";
        String s9 = "eccer";
        System.out.println(isAlmostPalindrome(s));
        System.out.println(isAlmostPalindrome(s1));
        System.out.println(isAlmostPalindrome(s2));
        System.out.println(isAlmostPalindrome(s3));
        System.out.println(isAlmostPalindrome(s4));
        System.out.println(isAlmostPalindrome(s5));
        System.out.println(isAlmostPalindrome(s6));
        System.out.println(isAlmostPalindrome(s7));
        System.out.println(isAlmostPalindrome(s8));
        System.out.println(isAlmostPalindrome(s9));
    }
}
