import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int N = Integer.parseInt(scan.nextLine());
            if(N == 0){
                break;
            }
            Result[] numbers = new Result[N];
            StringTokenizer st = new StringTokenizer(scan.nextLine());
            for(int i = 0; i < N; i++){
                numbers[i] = new Result(st.nextToken());
            }
            Arrays.sort(numbers);
            while(N-- > 0){
                System.out.print(numbers[N].num);
            }
            System.out.println();
        }
    }
}

class Result implements Comparable<Result> {
    
    public String num;

    public Result (String num) {
        this.num = num;
    }
    
    public int compareTo(Result o) {
    
        String x = this.num;
        String y = o.num;
        int i = 0, j = 0;
        int a = 0, b = 0;
        while(i < x.length() || j < y.length()){
            if(i == x.length()){
                i = a; 
                b = j;
            }
                
            if(j == y.length()){
                j = b; 
                a = i;
            }
            
            if(x.charAt(i) != y.charAt(j)){
                return x.charAt(i) - y.charAt(j);
            }
            
            i++;
            j++;
        }
        return y.length() - x.length();
    }
    
}