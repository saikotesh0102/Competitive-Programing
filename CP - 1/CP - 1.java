import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            String[] array = str.split(" ");
            int count;
            int max = 0;
            // System.out.println(Integer.parseInt(array[0]) + " " + Integer.parseInt(array[1]));
            if(Integer.parseInt(array[1]) > Integer.parseInt(array[0])){
                for(int i = Integer.parseInt(array[1]); i >= Integer.parseInt(array[0]); i--){
                    count = 1;
                    int n = i;
                    while(n != 1){
                        if (n%2 == 1){
                            n = (3 * n) + 1;
                            count++;
                        }else {
                            n = n/2;
                            count++;
                        }
                    }
                    if(count > max){
                        max = count; 
                    }
                }
            }
            else {
                for(int i = Integer.parseInt(array[0]); i >= Integer.parseInt(array[1]); i--){
                    count = 1;
                    int n = i;
                    while(n != 1){
                        if (n%2 == 1){
                            n = (3 * n) + 1;
                            count++;
                        }else {
                            n = n/2;
                            count++;
                        }
                    }
                    if(count > max){
                        max = count; 
                    }
                }
            }
            System.out.println(Integer.parseInt(array[0]) + " " + Integer.parseInt(array[1]) + " " + max);
        }
    }
}