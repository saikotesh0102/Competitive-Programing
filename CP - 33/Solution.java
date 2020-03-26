import java.io.*;
import java.util.*;

public class Solution {
    
    static Table[] tableSizes;
    static Team[] teamSizes;
    static int available;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int teams = Integer.parseInt(data[0]);
            int tables = Integer.parseInt(data[1]);
            if(teams == 0 && tables == 0){
                break;
            }
            String[] people = scan.nextLine().split(" ");
            teamSizes = new Team[teams];
            for(int i = 0; i < teams; i++){
                teamSizes[i] = new Team(i + 1, Integer.parseInt(people[i]));
            }
            String[] capacity = scan.nextLine().split(" ");
            tableSizes = new Table[tables];
            available = 0;
            for(int i = 0; i < tables; i++){
                tableSizes[i] = new Table(i + 1, Integer.parseInt(capacity[i]));
                if(tableSizes[i].Capacity > 0){
                    available++;
                }
            }
            Arrays.sort(teamSizes);
            boolean possible = true;
            for(int i = 0; i < teams && possible; i++){
                if(!seatTeam(i)){
                    possible = false;
                }
            }
            if(possible){
                sb.append("1\n");
                Arrays.sort(teamSizes, new ID());
                for(int i = 0; i < teams; i++){
                    Team cur = teamSizes[i];
                    // Arrays.sort(cur.tables);
                    for(int j = 0; j < cur.members; j++){
                        sb.append(cur.tables[j]).append(j == cur.members - 1 ? "\n" : " ");
                    }
                }
            }else{
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }
    
    static class Team implements Comparable<Team>{
        int id;
        int members;
        int[] tables;
        
        public Team(int id, int members){
            this.id = id;
            this.members = members;
            tables = new int[members];
        }
        
        public int compareTo(Team that) {
            return that.members - this.members;
        }
    }
    
    static class Table implements Comparable<Table>{
        int id;
        int Capacity;
            
        public Table(int id, int Capacity) {  
            this.id = id;
            this.Capacity = Capacity;
        }

        public int compareTo(Table that) {
            return that.Capacity - this.Capacity;
        }
    }
    
    static class ID implements Comparator<Team>{

        @Override
        public int compare(Team O1, Team O2) {
            // TODO Auto-generated method stub
            return O1.id - O2.id;
        }  
    }
    
    static boolean seatTeam(int idx){
        Team x = teamSizes[idx];
        if(x.members > available){
            return false;
        }
        Arrays.sort(tableSizes);
        for(int i = 0, j = 0; j < x.members; i++){
            if(tableSizes[i].Capacity>0){
                x.tables[j++] = tableSizes[i].id;
                tableSizes[i].Capacity--;
                if(tableSizes[i].Capacity == 0){
                    available--;
                }
            }
        }
        return true;
    }
}