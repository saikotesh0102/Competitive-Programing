import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        if(t >= 1 && t <= 40) {
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(scan.nextLine());
                int count = 0;
                if(n >= 1 && n <= 10000) {
                    String[] array = new String[n];
                    for(int j = 0; j < n; j++) {
                        array[j] = scan.nextLine();
                    }
            
                    for(int k = 0; k < array.length; k++) {
                        for(int l = 0; l < array.length; l++) {
                            if(array[l].startsWith(array[k])) {
                                count++;
                            }
                        }
                    }
                    if(count > n) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                } else {
                    System.out.println("NO");
                }
            } 
        } else {
                System.out.println("NO");
        }
    }
}