import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testcases; i++){
            String[] data = scan.nextLine().split(" ");
            int length = Integer.parseInt(data[0]);
            int ants = Integer.parseInt(data[1]);
            if(ants == 0){
                System.out.println("0 0");
                continue;
            }
            int min = 0; 
            int max = 0;
            String[] positions = scan.nextLine().split(" ");
            for(int j = 0; j < ants; j++){
                int current = Integer.parseInt(positions[j]);
                min = Math.max(min, Math.min(current, length - current));
                max = Math.max(max, Math.max(current, length - current));
            }
            System.out.println(min + " " + max);
        }
    }
}