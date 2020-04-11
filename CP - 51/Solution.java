import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        HashSet<String> result = new HashSet<String>();
        TreeSet<String> sorter = new TreeSet<String>(new Sorter());
        while(testcases-- > 0){
            scan.nextLine();
            int N = Integer.parseInt(scan.nextLine());
            result.clear();
            sorter.clear();
            String[] data = new String[N];
            for(int j = 0; j < N; j++){
                data[j] = scan.nextLine();
            }
            
            for (int j = 0; j < data.length; j++){
                for (int k = 0; k < data[j].length(); k++) {
                    solve(j, k, "", data, result);
                }
            }
            
            for(String m : result){
                sorter.add(m);
            }
            
            for(String m : sorter){
                System.out.println(m);
            }
            
            if(testcases != 0){
                System.out.println();
            }
        }
    }
    
    public static class Sorter implements Comparator<String>{

        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()){
                return o1.length() - o2.length();
            }else{
                return o1.compareTo(o2);
            }
        }  
    }
    
    public static void solve(int i, int j, String s, String[] data, HashSet<String> result) {
        s = s + data[i].charAt(j);
        for (int y = i - 1; y <= i + 1; y++){
            for (int x = j - 1; x <= j + 1; x++){
                if (x >= 0 && y >= 0 && y < data.length && x < data[y].length() && data[y].charAt(x) > data[i].charAt(j)) {
                    solve(y, x, s, data, result);
                }
            }
        }
        if (s.length() >= 3) {
            result.add(s);
        }
    }
}