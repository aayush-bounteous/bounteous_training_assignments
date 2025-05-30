package Coding_Assesment.Asessment23May;

import java.util.*;
public class q2 {

    public static int subarraysum(int[] num, int k){
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0, 1);
        int count=0;
        int sum=0;
        for(int n : num){
            sum+=n;
            if(hs.containsKey(sum-k)){
                count+=hs.get(sum-k);

            }
            hs.put(sum,hs.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int size=sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter target");
        int target=sc.nextInt();
        System.out.println("Number of subarrays : " + subarraysum(arr, target));

        
    }
}
