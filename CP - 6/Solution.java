import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String[] array = scan.nextLine().split(" ");
            double height = Integer.parseInt(array[0]);
            double up = Integer.parseInt(array[1]);
            double down = Integer.parseInt(array[2]);
            double fatigue = Integer.parseInt(array[3]);
            int daycount = 0;
            double initialHeight = 0;
            double fatigueFactor = (up * fatigue) / 100;
            if(height == 0 && up == 0 && down == 0 && fatigue == 0) {
                break;
            } else {
                while(true) {
                    if(daycount >= 1) {
                        initialHeight = initialHeight + (up - fatigueFactor);
                        up = up - fatigueFactor;
                        daycount++;
                        if(initialHeight > height) {
                            System.out.println("success on day " + daycount);
                            break;
                        } 
                        initialHeight = initialHeight - down;
                        if(initialHeight < 0) {
                            System.out.println("failure on day " + daycount);
                            break;
                        }
                    } else {
                        initialHeight = initialHeight + up;
                        daycount++;
                        if(initialHeight > height) {
                            System.out.println("success on day " + daycount);
                            break;
                        }
                        initialHeight = initialHeight - down;
                    }
                }
            }
        }
    }
}