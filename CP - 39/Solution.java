import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 1; i <= testcases; i++){
            String[] data = scan.nextLine().split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            int L = Integer.parseInt(data[2]);
            
            ArrayList<Agency> result = new ArrayList<Agency>();
            for(int j = 0; j < L; j++){
                String[] data1 = scan.nextLine().split(":");
                Agency name = new Agency(data1[0]);
                String[] data2 = data1[1].split(",");
                int A = Integer.parseInt(data2[0]);
                int B = Integer.parseInt(data2[1]);
                
                int X = N;
                while(X != M){
                    if(X/2 < M){
                        name.cost += (X - M) * A;
                        break;
                    }else{
                        name.cost += Math.min(B, (X - X/2) * A);
                        X = X/2;
                    }
                }
                result.add(name);
            }
            Collections.sort(result);
            sb.append("Case " + i + "\n");
            for(int j = 0; j < L; j++){
                sb.append(result.get(j).name + " " + result.get(j).cost + "\n");
            }
        }
        System.out.print(sb.toString());
    }
}

class Agency implements Comparable<Agency>{
    public String name;
    public int cost;
    public Agency(String name) {
        this.name = name;
    }
    
    public int compareTo(Agency that){
        if(cost != that.cost){
            return cost - that.cost;
        }
        return name.compareTo(that.name);
    }
}