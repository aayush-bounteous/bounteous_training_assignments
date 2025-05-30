// Problem 9
// Given a string s consisting of words and spaces, return the length of the last word in the string.
// A word is a maximal 
// substring
// consisting of non-space characters only.

import java.util.*;
public class q9 {

    public static int findlastwordlength(String s){
        String[] str=s.split(" ");
        String word=str[str.length-1];
        return word.length();

        // return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();

        System.out.println("Length of last word is : "+findlastwordlength(str));

    }
}
