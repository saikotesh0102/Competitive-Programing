import java.io.*;
import java.util.*;

public class Solution {
    
    public static int max = 0;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int size = Integer.parseInt(scan.nextLine());
            if(size == 0){
                break;
            }
            char[][] board = new char[size][size];
            max = 0;
            for(int i = 0; i < size; i++){
                board[i] = scan.nextLine().toCharArray();
            }
            int [][] stackLevel = new int [size][size];
            search(board, stackLevel, 0);
            System.out.println(max);
        }
    }
    
    public static class Coordinate {
        public final int x; 
        public final int y; 
        public Coordinate(int x, int y) { 
            this.x = x; 
            this.y = y; 
        } 
    }
    
    public static void search(char [][] board, int [][] stackLevel, int fillCount) {
        max = Math.max(max,fillCount);
        for (int rx = 0; rx < board.length; rx++){
            for (int ry = 0; ry < board[rx].length; ry++){
                if (stackLevel[rx][ry] == 0 && board[rx][ry] == '.') {
                    ArrayList<Coordinate> list = new ArrayList<>();
                    int x = rx+1;
                    while (x < board.length && board[x][ry] == '.') {
                        list.add(new Coordinate(x,ry));
                        stackLevel[x][ry]++;
                        x++;
                    }
                    x = rx-1;
                    while (x >= 0 && board[x][ry] =='.') {
                        list.add(new Coordinate(x,ry));
                        stackLevel[x][ry]++;
                        x--;
                    }
                    int y = ry+1;
                    while (y < board[rx].length && board[rx][y] =='.') {
                        list.add(new Coordinate(rx,y));
                        stackLevel[rx][y]++;
                        y++;
                    }
                    y = ry-1;
                    while (y >= 0 && board[rx][y] == '.') {
                        list.add(new Coordinate(rx,y));
                        stackLevel[rx][y]++;
                        y--;
                    }

                    stackLevel[rx][ry]++;

                    search(board,stackLevel,fillCount+1);

                    for (Coordinate c : list){
                        stackLevel[c.x][c.y]--;
                    }
                    stackLevel[rx][ry]--;
                }
            }
        }
    }
}