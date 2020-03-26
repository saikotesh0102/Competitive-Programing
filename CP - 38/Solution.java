import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int set = 1;
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int numberOfChambers = Integer.parseInt(data[0]);
            int numberOfSpecimens = Integer.parseInt(data[1]);
            String[] massdata = scan.nextLine().split(" ");
            int[] masses = new int[2 * numberOfChambers];
            double sum = 0;
            for(int i = 0; i < numberOfSpecimens; i++){
                masses[i] = Integer.parseInt(massdata[i]);
                sum = sum + masses[i];
            }
            Arrays.sort(masses);
            double imbalance = 0;
            sb.append("Set #" + set++ + "\n");
            for(int i = 0; i < numberOfChambers; i++){
                sb.append(" " + i + ":");
                int s1 = masses[i];
                int s2 = masses[(2 * numberOfChambers) - 1 - i];
                if(s1 == 0 || s2 == 0){
                    if(s1 != 0){
                        sb.append(" " + s1);
                    }
                    
                    if(s2 != 0){
                        sb.append(" " + s2);
                    }
                }
                else{
                    sb.append(" "+ s1 + " " + s2);
                }
                imbalance = imbalance + Math.abs((s1 + s2) - (sum / numberOfChambers));
                sb.append("\n");
            }
            sb.append("IMBALANCE = " + new DecimalFormat("0.00000").format(imbalance) + "\n\n");
        }
        System.out.println(sb.toString());
    }
}