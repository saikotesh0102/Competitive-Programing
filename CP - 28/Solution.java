import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int number = Integer.parseInt(scan.nextLine());
            if(number == 0){
                break;
            }
            int[] data = new int[number];
            String result = "";
            for(int i = 0; i < number; i++){
                data[i] = Integer.parseInt(scan.nextLine());
                if(data[i] != 0){
                    result += data[i] + " ";
                }
            }
            if(result == ""){
                System.out.println("0");
            }else{
                System.out.println(result);
            }
        }
    }
}