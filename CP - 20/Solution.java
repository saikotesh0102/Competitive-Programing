import java.io.*;
import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            int hh = Integer.parseInt(line.substring(0, 2));
            int mm = Integer.parseInt(line.substring(2, 4));
            int ss = Integer.parseInt(line.substring(4, 6));
            int cc = Integer.parseInt(line.substring(6));
            
            cc =  125 * (hh*60*60*100 + mm*60*100 + ss*100 + cc) /108;
            hh = cc / 1000000;
            cc = cc % 1000000;
            mm = cc / 10000;
            cc = cc % 10000;
            ss = cc / 100;
            cc = cc % 100;
            
            sb.append(new DecimalFormat("0").format(hh)).append(new DecimalFormat("00").format(mm)).append(new DecimalFormat("00").format(ss)).append(new DecimalFormat("00").format(cc)).append("\n");
        }
        System.out.println(sb);
    }
}