import java.io.*;
import java.util.*;

public class Solution {
    
    public static int N;
    public static boolean[][] adjMatrix;
    public static boolean visited[];

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcases = Integer.parseInt(br.readLine());
        br.readLine();
        
        while(testcases-- > 0){
            N = br.readLine().charAt(0) - 'A' + 1;
            adjMatrix = new boolean[N][N];
            String line;
            while(br.ready() && !(line = br.readLine()).equals("")){
                int u = line.charAt(0) - 'A';
                int v = line.charAt(1) - 'A';
                adjMatrix[u][v] = adjMatrix[v][u] = true;
            }
            visited = new boolean[N];
            int c = 0;
            for(int i = 0; i < N; i++){
                if(!visited[i]){
                    c++;
                    dfs(i);
                }
            }
            sb.append(c + "\n");
            if(testcases != 0){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    public static void dfs(int u){
        visited[u] = true;
        for(int i = 0; i < N; i++){
            if(adjMatrix[u][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}