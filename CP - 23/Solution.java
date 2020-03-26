import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testcases; i++){
            int length = Integer.parseInt(scan.nextLine());
            String[] data = scan.nextLine().split(" ");
            int numberOfCoins = 1;
            int sum = 0;
            for(int j = 0; j < length; j++){
                // int coin = Integer.parseInt(data[j]);
                if(j > 0){
                    if (sum >= Integer.parseInt(data[j])) {
                        sum -= Integer.parseInt(data[j - 1]);
                        sum += Integer.parseInt(data[j]);
                    } else {
                        sum += Integer.parseInt(data[j]);
                        numberOfCoins++;
                    }
                }else {
                    sum = Integer.parseInt(data[j]);
                }
            }
            System.out.println(numberOfCoins);
        }
    }
}