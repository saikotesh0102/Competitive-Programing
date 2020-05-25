import java.io.*;
import java.util.*;

public class Solution {
    
    public static String line;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int a = 1; a <= testcases; a++){
            int M = Integer.parseInt(scan.nextLine());
            line = "";
            for(int i = 0; i < M; i++){
                int T = Integer.parseInt(scan.nextLine());
                String concat = scan.nextLine();
                for(int j = 0; j < T; j++){
                    line = line + concat; 
                }
            }
            // System.out.println(line);
            System.out.println("Case " + a + ":");
            int queries = Integer.parseInt(scan.nextLine());
            int query = 1;
            for(int i = 0; i < queries; i++){
                String[] data = scan.nextLine().split(" ");
                if(data[0].equals("F")){
                    toBucaneer(data);
                }
                if(data[0].equals("E")){
                    toBarbery(data);
                }
                if(data[0].equals("I")){
                    toInverse(data);
                }
                if(data[0].equals("S")){
                    System.out.print("Q" + query++ + ":");
                    countBucaneer(data);
                }
            }
        }
    }
    
    public static void toBucaneer(String[] data){
        String[] out = line.split("");
        int x = Integer.parseInt(data[1]);
        int y = Integer.parseInt(data[2]);
        for(int i = x; i <= y; i++){
            if(out[i].equals("0")){
                out[i] = "1";
            }
        }
        line = "";
        for(int i = 0; i < out.length; i++){
            line = line + out[i];
        }
    }
    
    public static void toBarbery(String[] data){
        String[] out = line.split("");
        int x = Integer.parseInt(data[1]);
        int y = Integer.parseInt(data[2]);
        for(int i = x; i <= y; i++){
            if(out[i].equals("1")){
                out[i] = "0";
            }
        }
        line = "";
        for(int i = 0; i < out.length; i++){
            line = line + out[i];
        }
    }
    
    public static void toInverse(String[] data){
        String[] out = line.split("");
        int x = Integer.parseInt(data[1]);
        int y = Integer.parseInt(data[2]);
        for(int i = x; i <= y; i++){
            if(out[i].equals("1")){
                out[i] = "0";
            }else if(out[i].equals("0")){
                out[i] = "1";
            }
        }
        line = "";
        for(int i = 0; i < out.length; i++){
            line = line + out[i];
        }
    }
    
    public static void countBucaneer(String[] data){
        String[] out = line.split("");
        int x = Integer.parseInt(data[1]);
        int y = Integer.parseInt(data[2]);
        int count = 0;
        for(int i = x; i <= y; i++){
            if(out[i].equals("1")){
                count = count + 1;
            }
        }
        System.out.print(" " + count + "\n");
    }
}