import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int T = scan.nextInt();
            int R = scan.nextInt();
            int H = scan.nextInt();
            
            boolean[][] TR = new boolean[T][R];
            boolean[][] RH = new boolean[R][H];
            boolean[][] HT = new boolean[H][T];
            
            int[] costT = new int[T]; 
            int[] costR = new int[R]; 
            int[] costH = new int[H];
            
            for(int i = 0; i < T; i++){
                costT[i] = scan.nextInt();
                for(int j = 0; j < R; j++){
                    if(scan.nextInt() == 0){
                        TR[i][j] = true;
                    }
                }
            }
            
            for(int i = 0; i < R; i++){
                costR[i] = scan.nextInt();
                for(int j = 0; j < H; j++){
                    if(scan.nextInt() == 0){
                        RH[i][j] = true;
                    }
                }
            }
            
            for(int i = 0; i < H; i++){
                costH[i] = scan.nextInt();
                for(int j = 0; j < T; j++){
                    if(scan.nextInt() == 0){
                        HT[i][j] = true;
                    }
                }
            }
            
            int ans = (int)1e9;
            int t = -1;
            int r = -1;
            int h = -1;
            
            for(int i = 0; i < T; i++){
                for(int j = 0; j < R; j++){
                    for(int k = 0; k < H; k++){
                        if(TR[i][j] && RH[j][k] && HT[k][i]){
                            int cur = costT[i] + costR[j] + costH[k];
                            if(cur < ans){
                                ans = cur;
                                t = i;
                                r = j;
                                h = k;
                            }
                        }
                    }
                }
            }
            
            if(t == -1){
                System.out.println("Don't get married!");
            }else{
                System.out.println(t + " " + r + " " + h + ":" + ans);
            }
        }
    }
}