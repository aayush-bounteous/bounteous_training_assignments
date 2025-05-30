// problem 3: 
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input 
// string is valid.

import java.util.*;

public class q3 {
    public static boolean checkparenthesis(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.peek();
                if (ch == ')' && top != '(' ||
                        ch == ']' && top != '[' ||
                        ch == '}' && top != '{') {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the parenthesis");
        String str = sc.nextLine();
        System.out.println("Valid Parenthesis : " + checkparenthesis(str));
    }
}