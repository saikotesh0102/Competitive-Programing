import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testcases; i++){
            if(i > 0){
                scan.nextLine();
            }
            int d = Integer.parseInt(scan.nextLine());
            int n = Integer.parseInt(scan.nextLine());
            int[][] grid = new int[1025][1025];
            for(int j = 0; j < n; j++){
                String[] data = scan.nextLine().split(" ");
                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                int population = Integer.parseInt(data[2]);
                
                for(int k = -d; k <= d; k++){
                    for(int l = -d; l <= d; l++){
                        int xx = k + x;
                        int yy = l + y;
                        if(valid(xx,yy)){
                            grid[xx][yy] = grid[xx][yy] + population;
                        }
                    }
                }
            }
            int x = -1;
            int y = -1;
            int max = 0;
            for(int k = 0; k <= 1024; k++){
                for(int l = 0; l <= 1024; l++){
                    if(grid[k][l] > max){
                        max = grid[x = k][y = l];
                    }
                }
            }
            System.out.println(x + " " + y + " " + max);
        }
    }
    
    public static boolean valid(int x, int y){
        return x >= 0 && y >= 0 && x <= 1024 && y <= 1024;
    }
}