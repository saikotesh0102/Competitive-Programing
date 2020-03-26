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
            int start = Integer.parseInt(data[1]);
            int sequence = 1;
            boolean flag = false;
            for(int j = 2; j <= length; j++){
                int current = Integer.parseInt(data[j]);
                if((flag == false && start > current) || (flag == true && start < current)){
                    sequence++;
                    flag = flag ^ true;
                }
                start = current;
            }
            System.out.println(sequence);
        }
    }
}