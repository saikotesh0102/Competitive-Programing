import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        br.readLine();
        for(int i = testcases; i > 0; i--){
            Team[] teams = new Team[101];
            for(int j = 0; j <= 100; j++){
                teams[j] = new Team(j);
            }
            String line;
            while(br.ready() && !(line=br.readLine()).equals("")){
                String[] data = line.split(" ");
                int id = Integer.parseInt(data[0]);
                int problem = Integer.parseInt(data[1]);
                int time = Integer.parseInt(data[2]);
                char situation = data[3].charAt(0);
                
                switch(situation){
                    case 'I':
                        teams[id].tried(problem);
                        break;
                    case 'C':
                        teams[id].solved(problem,time);
                        break;
                    default: 
                        teams[id].submit();
                }
            }
            Arrays.sort(teams);
            for(int j = 0; j <= 100; j++){
                Team cur = teams[j];
                if(cur.submission != 0){
                    System.out.println(cur.id + " " + cur.solved + " " + cur.penalty);
                }
            }
            if(i > 0){
                System.out.println();
            }
        }
    }
}

class Team implements Comparable<Team>{
    
    int id,solved,penalty,submission;
    int[] penalties = new int[10];
    
    Team(int x) {
        this.id = x;
    }
    
    void solved(int p, int t){
        if(penalties[p] != -1){
            solved++;
            penalty += penalties[p] + t;
            penalties[p] = -1;
        }
        submission++;
    }
    
    void tried(int p){
        if(penalties[p] != -1){
            penalties[p] = penalties[p] + 20;
        }
        submission++;
    }
    
    void submit(){
        submission++;
    }

    @Override
    public int compareTo(Team o) {
        if(this.solved != o.solved){
            return o.solved - this.solved;
        }
        if(this.penalty != o.penalty){
            return this.penalty - o.penalty;
        }
        return this.id - o.id;
    }   
}