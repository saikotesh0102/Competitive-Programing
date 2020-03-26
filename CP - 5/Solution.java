import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String[] array = scan.nextLine().split(" ");
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < array.length; i++) {
                StringBuilder str = new StringBuilder();
                str.append(array[i]);
                str = str.reverse();
                result.append(str);
                result.append(" ");
            }
            System.out.println(result);
        }
    }
}