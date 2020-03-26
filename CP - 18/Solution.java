import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    LinkedList<Integer> cache;
    int miss;
    public Solution() {
        cache = new LinkedList();
        miss = 0;
    }
    public void check(int a, int b) {
        if(!cache.contains(a)) {
            if(cache.size()<b) {
                cache.add(a);
                miss++;
            } else {
                cache.remove();
                cache.add(a);
                miss++;
            }
            
        } else {
            cache.remove((Integer)a);
            cache.add(a);
        }
    }
    public int stats() {
        return miss;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String a = in.nextLine();
        String[] temp = a.split(" ");
        int[] c_size = new int[N];
        Solution[] processs = new Solution[N];
        for(int i = 0; i < N; i++) {
            c_size[i]=Integer.parseInt(temp[i]) ;
            processs[i] = new Solution();
        }
        while(in.hasNextLine()){
            a = in.nextLine();
            temp = a.split(" ");
            if(temp[0].equals("RANGE")) {
                int b = Integer.parseInt(temp[1]);
                int y = Integer.parseInt(temp[2]);
                int n = Integer.parseInt(temp[3]);
                for(int j = 0; j < N; j++) {
                    // System.out.println(b+(i*y));
                     for (int i = 0; i < n; i++){
                        processs[j].check(b+(i*y),c_size[j]);
                    }
                }
            } else if(temp[0].equals("ADDR")) {
                for(int j = 0; j < N; j++) {
                    processs[j].check(Integer.parseInt(temp[1]),c_size[j]);
                }
            } else if(temp[0].equals("STAT")) {
                for(int j = 0; j < N; j++) {
                    System.out.print(processs[j].stats()+" ");
                    processs[j].miss=0;
                }
                System.out.println();
            }else if(temp[0].equals("END")) {
                break;
            }
        }
    }
}