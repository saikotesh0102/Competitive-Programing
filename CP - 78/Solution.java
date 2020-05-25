import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        
        while(testcases-- > 0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            UnionFind uf = new UnionFind(n);
            
            while(m-->0){
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                uf.unionSet(u, v);
            }
            
            int max = 1;
            for(int i = 0; i < n; ++i){
                max = Math.max(max, uf.setSize[i]);
            }
            System.out.println(max);
        }
    }
    
    static class UnionFind {                                              
        public int[] p, rank, setSize;
        public int numSets;
        
        public UnionFind(int N) {
             p = new int[N];
             rank = new int[N];
             setSize = new int[N];
             numSets = N;
             for (int i = 0; i < N; i++) {  
                 p[i] = i; setSize[i] = 1; 
             }
        }
        
        public int findSet(int i) { 
            if (p[i] == i){
                return i;
            }else{
                return p[i] = findSet(p[i]);
            }
         }
        
        public Boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j); 
        }
        
        public void unionSet(int i, int j) { 
             if (isSameSet(i, j)){
                 return;
             }
             numSets--; 
             int x = findSet(i), y = findSet(j);
             // rank is used to keep the tree short
             if (rank[x] > rank[y]) { 
                 p[y] = x; setSize[x] += setSize[y]; 
             }else{    
                 p[x] = y; setSize[y] += setSize[x];
                 if(rank[x] == rank[y]) rank[y]++; 
             } 
        }
        
        public int numDisjointSets() { 
            return numSets; 
        }
        
        public int sizeOfSet(int i) { 
            return setSize[findSet(i)]; 
        }
    }
}