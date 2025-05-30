// Problem 5: 
// Two strings are considered close if you can swap letters or change the frequency of any 
// letter to match the other string. Determine if two given strings are close.
import java.util.*;

public class q5 {
    public static boolean similar(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        boolean res= Arrays.equals(ch1, ch2);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1");
        String s1=sc.nextLine();

        System.out.println("Enter string 2");
        String s2= sc.nextLine();

System.out.println("Similar : "+ similar(s1, s2));
        
    }
}
