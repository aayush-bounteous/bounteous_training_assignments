// Problem 8
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or 
// -1 if needle is not part of haystack
import java.util.*;
public class q8 {

    public static int firstindice(String h, String n) {
    int hlen = h.length();
    int nlen = n.length();

 

    for (int i = 0; i <= hlen - nlen; i++) {
        String subword = h.substring(i, i + nlen);
        if (n.equals(subword)) {
            return i;
        }
    }

    return -1;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter haystack");
        String str1=sc.nextLine();
        System.out.println("Enter needle");
        String str2=sc.nextLine();

        if(str1.length()<str2.length()){
            System.out.println("ERROR! Needle is bigger than haystack");
            System.exit(0);
        }
        System.out.println("First Indice is : " + firstindice(str1, str2));


        
    }
}
