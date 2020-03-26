import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            char[] s = data[0].toCharArray();
            char[] t = data[1].toCharArray();
            
            int i = 0;
            int j = 0;
            while(i < s.length && j < t.length){
                if(s[i] == t[j]){
                    i++;
                }
                j++;
            }
            if(i == s.length){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}