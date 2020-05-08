import java.io.*;
import java.util.*;

public class Solution {
    
    public static int[][] grid;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int N = Integer.parseInt(scan.nextLine());
            grid = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] data = scan.nextLine().split(" ");
                for(int j = 0; j < N; j++){
                    grid[i][j] = Integer.parseInt(data[j]);
                }
            }
            
            int query = Integer.parseInt(scan.nextLine());
            for(int i = 0; i < query; i++){
                String[] line = scan.nextLine().split(" ");
                if(line[0].equals("q")){
                    result(line);
                }else if(line[0].equals("c")){
                    update(line);
                }
            }
        }
    }
    
    public static void result(String[] line){
        int x1 = Integer.parseInt(line[1]) - 1;
        int x2 = Integer.parseInt(line[2]) - 1;
        int y1 = Integer.parseInt(line[3]) - 1;
        int y2 = Integer.parseInt(line[4]) - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = Math.min(x1,y1); i <= Math.max(x1,y1); i++){
            for(int j = Math.min(x2,y2); j <= Math.max(x2,y2); j++){
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
                if(grid[i][j] < min){
                    min = grid[i][j];
                }
            }
        }
        System.out.println(max + " " + min);
    }
    
    public static void update(String[] line){
        int value = Integer.parseInt(line[3]);
        // System.out.println(grid[Integer.parseInt(line[1]) - 1][Integer.parseInt(line[2]) - 1]);
        grid[Integer.parseInt(line[1]) - 1][Integer.parseInt(line[2]) - 1] = value;
        // System.out.println(grid[Integer.parseInt(line[1]) - 1][Integer.parseInt(line[2]) - 1]);
    }
}