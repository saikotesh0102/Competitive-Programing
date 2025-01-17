import java.util.*;
import java.io.*;

public class Solution {

    public static Player[] players;
    public static Pair[][] memo;
    
    static Pair dp(int idx, int attack){
        if(idx == 10)
            return new Pair(0, 0);
        if(memo[idx][attack] != null)
            return memo[idx][attack];
        
        Pair ans = new Pair(0, 0), nxt;
        
        if(attack < 5){
            nxt = dp(idx + 1, attack + 1);
            ans = new Pair(nxt.att + players[idx].att, nxt.def);
        }
        
        if(idx - attack < 5){
            nxt = dp(idx + 1, attack);
            if(nxt.att > ans.att || nxt.att == ans.att && nxt.def + players[idx].def > ans.def)
                ans = new Pair(nxt.att, nxt.def + players[idx].def);
        }
                
        return memo[idx][attack] = ans;
    }
    
    static String[] attackers, defenders;
    
    static void print(int idx, int attack){
        if(idx == 10)
            return;
        Pair optimal = dp(idx, attack), nxt = null;
        if(attack < 5)
            nxt = dp(idx + 1, attack + 1);
        if(nxt != null && optimal.equals(new Pair(nxt.att + players[idx].att, nxt.def))){
            attackers[attack] = players[idx].name;
            print(idx + 1, attack + 1);
        }else{
            defenders[idx - attack] = players[idx].name;
            print(idx + 1, attack);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
    
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; ++t)
        {
            players = new Player[10];
            for(int i = 0; i < 10; ++i)
                players[i] = new Player(sc.next(), sc.nextInt(), sc.nextInt());
            Arrays.sort(players);
            memo = new Pair[10][6];
            attackers = new String[5];
            defenders = new String[5];
            print(0, 0);
            out.format("Case %d:\n(", t);
            for(int i = 0; i < 5; ++i)
                out.format("%s%s", attackers[i], i == 4?")\n(":", ");
            for(int i = 0; i < 5; ++i)
                out.format("%s%s", defenders[i], i == 4?")\n":", ");
            
        }
    
        out.flush();
        out.close();
    }
    
    static class Pair
    {
        int att, def;
        
        Pair(int x, int y)
        {
            att = x; def = y;
        }
        
        public boolean equals(Pair p)
        {
            return att == p.att && def == p.def;
        }
    }
    
    static class Player implements Comparable<Player>
    {
        int att, def;
        String name;
        Player(String x, int y, int z)
        {
            name = x;
            att = y;
            def = z;
        }
        
        public int compareTo(Player p)
        {
            return name.compareTo(p.name);
        }
        
    }
}