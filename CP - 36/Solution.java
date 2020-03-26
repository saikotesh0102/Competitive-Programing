import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testcases; i++){
            int items = Integer.parseInt(scan.nextLine());
            String[] data = scan.nextLine().split(" ");
            int[] prices = new int[items];
            for(int j = 0; j < items; j++){
                prices[j] = Integer.parseInt(data[j]);
            }
            Arrays.sort(prices);
            int discount = 0;
            for(int j = items - 3; j >= 0; j = j - 3){
                discount = discount + prices[j];
            }
            System.out.println(discount);
        }
    }
}