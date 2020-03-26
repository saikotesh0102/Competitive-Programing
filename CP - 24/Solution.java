import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static class LineSegment implements Comparable<LineSegment>{
        int x1,x2;
        public LineSegment(int x1,int x2){
            this.x1 = x1;
            this.x2 = x2;
        }
        
        public int compareTo(LineSegment that) {
            if(this.x1 != that.x1)
                return this.x1 - that.x1;
            return that.x2 - this.x1;
        }
        
        public String toString(){
            return x1 +" "+ x2;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int a = 0; a < testcases; a++){
            if(a > 0){
                sb.append("\n");
            }
            scan.nextLine();
            int m = Integer.parseInt(scan.nextLine());
            ArrayList<LineSegment> input = new ArrayList<LineSegment>();
            while(true){
                String[] data = scan.nextLine().split(" ");
                int l = Integer.parseInt(data[0]);
                int r = Integer.parseInt(data[1]);
                if(l == 0 && r == 0){
                    break;
                }
                if(r >= 0){
                    input.add(new LineSegment(l,r));
                }
            }
            Collections.sort(input);
            ArrayList<LineSegment> result = new ArrayList<LineSegment>();
            boolean flag = true;
            int lastEnd = 0;
            int ans = 0;
            for(int i = 0; flag && lastEnd < m; ){
                flag = false;
                int tmp = lastEnd,tmpbeg = 0;
                for( ; i < input.size() && input.get(i).x1 <= lastEnd; i++){
                    flag = true;
                    if(input.get(i).x2 > tmp){
                        tmp = input.get(i).x2;
                        tmpbeg = input.get(i).x1;
                    }
                }
                if(tmp != lastEnd){
                    ans++;
                    result.add(new LineSegment(tmpbeg,tmp));
                }
                lastEnd = tmp;
            }
            if(lastEnd < m){
                sb.append(0 + "\n");
                continue;
            }
            Collections.sort(result);
            sb.append(ans + "\n");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}