import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int n = data.length;
            int[] A = new int[n];
            for(int i = 0; i < n; i++){
                sb.append(A[i] = Integer.parseInt(data[i])).append(i == n - 1 ? "\n" : " ");
            }
            int pos = n - 1;
            while(pos > 0){
                int max = 0, idx = -1;
                for(int i = 0; i < pos; ++i){
                    if(A[i] > max){
                        max = A[idx = i];
                    }
                }
                if(A[pos] < max){
                    if(idx != 0){
                        sb.append(n - idx + " ");
                        for(int i = 0, j = idx; i < j; ++i, --j){
                            int tmp = A[i]; 
                            A[i] = A[j]; 
                            A[j] = tmp;
                        }
                    }
                    
                    sb.append(n - pos + " ");
                    for(int i = 0, j = pos; i < j; ++i, --j){
                        int tmp = A[i]; 
                        A[i] = A[j]; 
                        A[j] = tmp;
                    }
                }
                pos--;
            }
            sb.append("0\n");
        }
        System.out.println(sb.toString());
    }
}