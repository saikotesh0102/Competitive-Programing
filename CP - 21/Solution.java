import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String data = scan.nextLine();
            if(data.equals("0 0 0")){
                break;
            }
            String[] boards = data.split(" ");
            int W = Integer.parseInt(boards[0]);
            int H = Integer.parseInt(boards[1]);
            int N = Integer.parseInt(boards[2]);
            
            int empty = W * H;
            boolean [][] flag = new boolean [W][H];
            
            for(int i = 0; i < N; i++){
                String[] points = scan.nextLine().split(" ");
                int x1=Integer.parseInt(points[0]);
                int y1=Integer.parseInt(points[1]);
                int x2=Integer.parseInt(points[2]);
                int y2=Integer.parseInt(points[3]);
                
                for (int x = Math.min(x1,x2); x <= Math.max(x1,x2); x++){
                    for (int y = Math.min(y1,y2); y <= Math.max(y1,y2); y++){
                        if (!flag[x-1][y-1]) {
                            flag[x-1][y-1] = true;
                            empty--;
                        }
                    }
                }
            }
            if (empty == 0){
                System.out.println("There is no empty spots.");
            } else if (empty==1){
                System.out.println("There is one empty spot.");
            } else{
                System.out.println("There are "+empty+" empty spots.");
            }
            scan.nextLine();
        }
    }
}