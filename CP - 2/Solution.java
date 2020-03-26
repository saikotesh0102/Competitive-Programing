import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        boolean open = true;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            for(int i = 0; i < line.length(); i++) {  
                 if(line.charAt(i) == '\"') {  
                      if(open) {  
                           System.out.print("``");  
                           open = false;
                           continue;
                      } else {  
                           System.out.print("''");  
                           open = true;
                           continue;
                      }  
                 }  
                 System.out.print(line.charAt(i));  
            }  
            System.out.print("\n");  
        }
    }
}