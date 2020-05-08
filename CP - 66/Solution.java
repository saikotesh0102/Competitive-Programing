import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while(scan.hasNextLine()){
            String data = scan.nextLine();
            if(data.equals("end")){
                break;
            }
            System.out.println("Case " + count++ + ": " + compute(data));
        }
    }
    
    public static int compute(String line){
        ArrayList<Integer> ships = new ArrayList<Integer>();
        boolean[] hasShip = new boolean[26];
        
        for(int i = 0; i < line.length(); i++){
            int c = line.charAt(i) - 'A';
            if(!hasShip[c]){
                hasShip[c] = true;
                int min = 1000;
                int idx = -1;
                for(int j = 0; j < ships.size(); j++){
                    int b = ships.get(j);
                    if(c <= b && b - c < min){
                        min = c - b;
                        idx = j;
                    }
                }
                if(idx == -1){
                    ships.add(c);
                }else{
                    hasShip[ships.get(idx)] = false;
                    ships.set(idx, c);
                }
            }
        }
        return ships.size();
    }
}