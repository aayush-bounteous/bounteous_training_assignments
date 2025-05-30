//q-3.Next Greater Element
// Given a circular array, find the next greater number for every element.
// 231 -> 312

import java.util.*;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num");
        int number = sc.nextInt();
        int copy = number;

        int size = 0;

        while (number > 0) {
            number = number / 10;
            size++;
        }

        int[] arr = new int[size];
        int i = size - 1;

        while (copy > 0) {
            int extra = copy % 10;
            arr[i] = extra;
            copy = copy / 10;
            i--;
        }

        // Find first decreasing digit from right
        int idx = -1;
        for (int j = size - 2; j >= 0; j--) {
            if (arr[j] < arr[j + 1]) {
                idx = j;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("No greater number possible");
            return;
        }

        //Find smallest digit on right side of idx that is greater than arr[idx]
        for (int j = size - 1; j > idx; j--) {
            if (arr[j] > arr[idx]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        // Step 3: Reverse the part after idx
        int start = idx + 1;
        int end = size - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        // Print final number
        System.out.print("Next greater number: ");
        for (int digit : arr) {
            System.out.print(digit);
        }
        System.out.println();
    }
}
