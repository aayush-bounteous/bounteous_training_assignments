
// 9. Rearrange a no to find min possible no in o(n) and constant space.
 
// for eg input 
// 1. 324 -> output 234
// 2. 50221 - 01225

import java.util.*;
public class q9
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int number =sc.nextInt();
		int copy=number;
		
		int size=0;
		
		while(number>0){
		    int extra=number%10;
		    number=number/10;
		    size++;
		}
		int[] arr= new int[size];
		int i=0;
		
		while(copy>0){
		     int extra=copy%10;
		     arr[i]=extra;
		    copy=copy/10;
		    i++;
		}
		Arrays.sort(arr);

		
		int finalnum=0;
		for(int j=0;j<i;j++){
		    finalnum*=10;
		    finalnum+=arr[j];
		}
		System.out.println(finalnum);
		
	
		
		
	}
}

