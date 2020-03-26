import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int z = 0; z < t;) {
            String s = scan.nextLine();
            if(s.equals("")) {
                continue;
            }
            int n = Integer.parseInt(s);
            if(n == 0){
                System.out.println(1 +"");
                System.out.println("-inf "+ "+inf " + "1.000");
                System.out.println(" ");
                 z++;
                continue;
                
            } 
            LineSegment[] lsArr = new LineSegment[n];
            double[] xArr = new double[2*n];
            int j = 0;
            for(int i = 0; i < n;) {
                s = scan.nextLine();
                if(s.equals("")) continue;
                String[] arr = s.split(" ");
                double x1 = Double.parseDouble(arr[0]);
                double y1 = Double.parseDouble(arr[1]);
                double x2 = Double.parseDouble(arr[2]);
                double y2 = Double.parseDouble(arr[3]);
                xArr[j] = x1;
                xArr[j+1] = x2;
                j = j+2;
                double transp = Double.parseDouble(arr[4]);
                lsArr[i] = new LineSegment(x1, y1, x2, y2, transp);
                i++;
            }
            Arrays.sort(xArr);
            double per = 1.0;
            System.out.println((2*n)+1);
            System.out.print("-inf"+ " ");
            System.out.printf("%1.3f %1.3f",xArr[0],per);
            System.out.println();
            int k = 0;
            for(k = 0; k < xArr.length-1; k++) {
                double x = xArr[k];
                per = 1.0;
               for(int m = n - 1; m >= 0; m--) {
                   double p = lsArr[m].x1;
                   double q = lsArr[m].x2;
                   if(p > q) {
                       p = lsArr[m].x2;
                       q = lsArr[m].x1;
                   }
                   if(p <= x && q > x ) {
                       per = lsArr[m].transp * (per);
                   }
               }
                System.out.printf("%1.3f %1.3f %1.3f",xArr[k],xArr[k+1],per);
                System.out.println();
            }
            per = 1.0;
            System.out.printf("%1.3f",xArr[k]);
            System.out.print(" +inf"+ " ");
            System.out.printf("%1.3f",per);
            System.out.println();
            System.out.println(" ");
             z++;
        }
        
    }
}
class LineSegment {
    double x1,y1,x2,y2;
    double transp;
    public LineSegment(double x1,double y1,double x2,double y2,double transp) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.transp = transp;
    }
}