// Problem 2: 
// Given a string ss, return the longest palindromic substring in ss

import java.util.*;

public class q2 {

    // public static String longestplain(String s) {
    //     int start = 0, maxlen = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         for (int j = 0; j < 2; j++) {
    //             int l = i, r = i + j;
    //             while (l >= 0 && r < s.length() && s.charAt(i) == s.charAt(r)) {
    //                 l--;
    //                 r++;
    //             }
    //                 if (r - l - 1 > maxlen) {
    //                     maxlen = r - i - 1;
    //                     start = l + 1;
    //             }
    //         }
    //     }
    //     return s.substring(start,start+maxlen);
    // }
    public static String longestplain(String s) {
    int start = 0, maxlen = 0;

    for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < 2; j++) {
            int l = i, r = i + j;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > maxlen) {
                maxlen = r - l - 1;
                start = l + 1;
            }
        }
    }

    return s.substring(start, start + maxlen);
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String str = sc.nextLine();

        System.out.println("Longest palindrome : " + longestplain(str));

    }
}
