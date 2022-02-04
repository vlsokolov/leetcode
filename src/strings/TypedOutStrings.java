package strings;

import java.util.Stack;

public class TypedOutStrings {

    public static boolean compareStrings(String s, String t) {
       char[] chars1 = s.toCharArray();
       char[] chars2 = t.toCharArray();

       int p1 = chars1.length - 1;
       int p2 = chars2.length - 1;

       while (p1 >= 0 && p2 >= 0) {
           p1 = findPointerPosition(chars1, p1);
           p2 = findPointerPosition(chars2, p2);

           if (p1 >= 0 && p2 >= 0) {
               if (chars1[p1] != chars2[p2]) {
                   return false;
               } else {
                   p1--;
                   p2--;
                   if (p1 >= 0) {
                       p1 = findPointerPosition(chars1, p1);
                   }
                   if (p2 >= 0) {
                       p2 = findPointerPosition(chars2, p2);
                   }
               }
           } else {
               return p1 == p2;
           }
       }

       return p1 == p2;
    }

    private static int findPointerPosition(char[] chars, int p) {
        if (chars[p] == '#') {
            int shiftCounter = 2;
            while (shiftCounter > 0) {
                p--;
                shiftCounter--;
                if (p < 0) break;
                if (chars[p] == '#') {
                    shiftCounter = shiftCounter + 2;
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "#a";
        String s3 = "abc#d";
        String s4 = "acc#c";
        String s5 = "x#y#z#";
        String s6 = "a#";
        String s7 = "aaaa###b";
        String s8 = "b";
        String s9 = "Ab#z";
        String s10 = "ab#z";
        System.out.println(compareStrings(s1, s2));
        System.out.println(compareStrings(s3, s4));
        System.out.println(compareStrings(s5, s6));
        System.out.println(compareStrings(s7, s8));
        System.out.println(compareStrings(s9, s10));
    }
}
