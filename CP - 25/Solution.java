import java.io.*;
import java.util.*;

class Job implements Comparable<Job>{
    int day;
    int days;
    int fine;
    double ratio;
    Job(int day,int days,int fine){
        this.day = day;
        this.days = days;
        this.fine = fine;
        this.ratio = fine/(double)days;
    }
    public int compareTo(Job that){
        if (this.ratio < that.ratio){
            return 1;
        }
        else if(this.ratio > that.ratio){
            return -1;
        }
        else{
            if (this.day > that.day){
                return 1;
            }
            else if(this.day < that.day){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++){
            sc.nextLine();
            int lines = Integer.parseInt(sc.nextLine());
            Job[] work = new Job[lines];
            for(int j = 0;j < lines; j++){
                String[] s = sc.nextLine().split(" ");
                work[j] = new Job(j+1,Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            }
            Arrays.sort(work);
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < lines; j++){
                sb.append(work[j].day+" ");
            }
            System.out.println(sb);
            if (testcases > 1){
                System.out.println();
            }
        }
    }
}