import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcase = 1;
        while(scan.hasNextLine()) {
            // if(scan.nextLine().equals("0 0")) {
            //     break;
            // }
            String[] data = scan.nextLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int p = Integer.parseInt(data[1]);
            
            if(n == 0 && p == 0) {
                break;
            }
            
            for(int i = 0; i < n; i++) {
                scan.nextLine();
            }
            
            String selectedCarName = "";
            int selectedCarReqCount = 0;
            double selectedCarPrice = 0.0;
            
            for(int i = 0; i < p; i++) {
                String carName = scan.nextLine();
                String[] prices = scan.nextLine().split(" ");
                double carPrice = Double.parseDouble(prices[0]);
                int metRequirements = Integer.parseInt(prices[1]);
                for(int j = 0; j < metRequirements; j++) {
                    scan.nextLine();
                }
                if((metRequirements > selectedCarReqCount) || (metRequirements == selectedCarReqCount && selectedCarPrice > carPrice)) {
                    selectedCarName = carName;
                    selectedCarReqCount = metRequirements;
                    selectedCarPrice = carPrice;
                }
            }
            
            if (testcase > 1) {
                System.out.println();
            }
            
            System.out.println("RFP #" + testcase + "\n" + selectedCarName);
            testcase++;
        }
    }
}