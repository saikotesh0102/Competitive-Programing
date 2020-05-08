import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int scenario = 1;
        while(scan.hasNextLine()){
            int teams = Integer.parseInt(scan.nextLine());
            if(teams == 0){
                break;
            }
            TeamQueue x = new TeamQueue(teams);
            System.out.println("Scenario #" + scenario++);
            while(teams-- > 0){
                StringTokenizer st = new StringTokenizer(scan.nextLine());
                int n = Integer.parseInt(st.nextToken());
                int[] id = new int[n];
                for(int i = 0; i < n; i++){
                    id[i] = Integer.parseInt(st.nextToken());
                }
                x.addTeam(id);
            }
            while(true){
                StringTokenizer st = new StringTokenizer(scan.nextLine());
                String comm = st.nextToken();
                if(comm.equals("STOP")){
                    break;
                }
                if(comm.equals("DEQUEUE")){
                    System.out.println(x.dequeue());
                }else{
                    x.enqueue(Integer.parseInt(st.nextToken()));
                }
            }
            System.out.println();
        }
    }
}

class TeamQueue{
    public int[] teamOf;
    public int nxt;
    public Queue<Integer> queue;
    public Queue<Integer>[] team_queue;
    
    public TeamQueue(int teams){
        this.queue = new LinkedList<Integer>();
        this.team_queue = new LinkedList[teams];
        for(int i = 0; i < teams; i++){
            team_queue[i] = new LinkedList<Integer>();
        }
        this.teamOf = new int[1000000];
    }
    
    public void addTeam(int[] id){
        for(int i = 0; i < id.length; i++){
            teamOf[id[i]] = nxt;
        }
        nxt++;
    }
    
    public void enqueue(int id){
        int team = teamOf[id];
        if(team_queue[team].size() == 0){
            queue.add(team);
        }
        team_queue[team].add(id);        
    }
    
    public int dequeue(){
        int ret = team_queue[queue.peek()].remove();
        if(team_queue[queue.peek()].size() == 0){
            queue.remove();
        }
        return ret;
    }
}