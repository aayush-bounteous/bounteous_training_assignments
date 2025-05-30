// 1. Two Sum II - Input array is sorted
// Given a sorted array of integers, return the indices of the two numbers such that they add up to a specific target.

import java.util.*;
public class q1
{
    public static void bruteforce(int[] arr, int tar, int size){
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if((arr[i]+arr[j]==tar)){
                    System.out.println(i+" "+j);
                }
            }
        }
        
    }
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size");
		int size=sc.nextInt();
		System.out.println("Enter elements");
		int[] arr=new int[size];
		for(int i=0; i<size; i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter target");
		int target=sc.nextInt();
		bruteforce(arr,target,size);
		
		
	}
}