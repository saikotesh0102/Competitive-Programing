import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int testcase = 1;
        while(scan.hasNextLine()) {
            String[] array = scan.nextLine().split(" ");
            // System.out.println(Arrays.toString(array));
            int n = Integer.parseInt(array[0]);
            int m = Integer.parseInt(array[1]);
            int c = Integer.parseInt(array[2]);
            int sum = 0;
            int power = 0;
            int maxCapacity = 0;
            if(n == 0 && m == 0 && c == 0) {
                break;
            }
            boolean[] flag = new boolean[n];
            for(int i = 0 ; i < n; i++) {
                flag[i] = false;
            }
            int[] capacity = new int[n];
            for(int i = 0; i < n; i++) {
                capacity[i] = Integer.parseInt(scan.nextLine());
            }
            
            for(int i = 0; i < m; i++) {
                int toggle = Integer.parseInt(scan.nextLine());
                
                if(flag[toggle - 1] == false) {
                    sum = sum + capacity[toggle - 1];
                    if(sum > c) {
                        i++;
                        while(i < m) {
                            Integer.parseInt(scan.nextLine());
                            i++;
                        }
                    }
                    flag[toggle - 1] = true;
                } else if(flag[toggle - 1] == true) {
                    sum = sum - capacity[toggle - 1];
                    flag[toggle - 1] = false;
                }
                
                if(sum  > maxCapacity) {
                    maxCapacity = sum;
                }
            }
            if (sum > c) {
                System.out.println("Sequence " + testcase++);
                System.out.println("Fuse was blown.");
            }
            else{
                System.out.println("Sequence " + testcase++);
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was "+ maxCapacity + " amperes.");
            }
            System.out.println("");
        }
    }
}