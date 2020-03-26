import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 1; i <= testcases; i++){
            int length = Integer.parseInt(scan.nextLine());
            String data = scan.nextLine();
            int start = 0;
            int count = 0;
            
            for(int j = 0; j < length; j++){
                if((j - start) == 1){
                    start = j + 2;
                    j++;
                    count++;
                }else if(data.charAt(j) == '#'){
                    start = j + 1;
                }
            }
            if(start == length - 1){
                count++;
            }
            System.out.println("Case " + i + ": " + count);
        }
    }
}