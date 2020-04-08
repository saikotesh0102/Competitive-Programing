import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            if(data.length == 1){
                break;
            }
            int frontSprockets = Integer.parseInt(data[0]);
            int rearSprockets = Integer.parseInt(data[1]);
            
            int[] numberOfTeethF = new int[frontSprockets];
            int[] numberOfTeethR = new int[rearSprockets];
            double[] result = new double[frontSprockets * rearSprockets];
            
            String[] dataFront = scan.nextLine().split(" ");
            String[] dataRear = scan.nextLine().split(" ");
            
            for(int i = 0; i < frontSprockets; i++){
                numberOfTeethF[i] = Integer.parseInt(dataFront[i]);
            }
            
            for(int i = 0; i < rearSprockets; i++){
                numberOfTeethR[i] = Integer.parseInt(dataRear[i]);
            }
            
            int index = 0;
            for(int i = 0; i < numberOfTeethF.length; i++){
                for(int j = 0; j < numberOfTeethR.length; j++){
                    result[index++] = (numberOfTeethR[j] * 1.0 / numberOfTeethF[i]);
                }
            }
            
            Arrays.sort(result);
            
            double max = 0;
            for(int i = 0; i < result.length - 1; i++){
                max = Math.max(max, result[i + 1] / result[i]);
            }
            System.out.printf("%.2f\n", max);
        }
    }
}