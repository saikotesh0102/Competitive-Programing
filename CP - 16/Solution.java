import java.io.*;
import java.util.*;

public class Solution {
    
    public int count(char c, char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == c){
                    count++;
                }
        return count;
    }
    
    public boolean win(char c, char[][] board) {
        boolean winning = true;
        for (int i = 0; i < 3; i++) {
            winning = true;
            for (int j = 0; j < 3 && winning; j++) {
                winning = (board[i][j] == c);
            }
            if (winning){
                return winning;
            }
        }

        for (int i = 0; i < 3; i++) {
            winning = true;
            for (int j = 0; j < 3 && winning; j++) {
                winning = (board[j][i] == c);
            }
            if (winning){
                return winning;
            }
        }
        
        winning = true;
        for (int i = 0; i < 3 && winning; i++) {
            winning = (board[i][i] == c);
        }
        if (winning){
            return winning;
        }

        winning = true;
        for (int i = 0; i < 3 && winning; i++) {
            winning = (board[2-i][i] == c);
        }
        if (winning){
            return winning;
        }
        return false;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution solution = new Solution();
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testcases; i++){
            if(i > 0) {
                scan.nextLine();
            }
            char[][] board = new char[3][3];
            for(int j = 0; j < 3; j++){
                board[j] = scan.nextLine().toCharArray(); 
            }
            
            boolean xwin = solution.win('X', board);
            boolean ywin = solution.win('O', board);

            int xcount = solution.count('X', board);
            int ycount = solution.count('O', board);
            
            String ans = "yes";
            if (xwin && ywin){
                ans = "no";
            }
            if (xcount < ycount || xcount > ycount + 1){
                ans = "no";
            }
            if (xwin && xcount != ycount + 1){
                ans = "no";
            }
            if (ywin && ycount != xcount){
                ans = "no";
            }
            System.out.println(ans);
        }
    }
}