import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine().trim());
        while(count-- > 0){
            int testcases = Integer.parseInt(scan.nextLine());
            Set set = new Set();
            String[] temp;
            for(int i = 0; i < testcases; i++){
                temp = scan.nextLine().split(" ");
                set.makeSet(temp[0]);
                set.makeSet(temp[1]);
                set.union(set.map.get(temp[0]), set.map.get(temp[1]));
                System.out.println(set.nMap.get(set.find(set.map.get(temp[0]))));
            }
        }
    }
    
    static class Set {

        List<Integer> parent, rank;
        HashMap<String, Integer> map;
        HashMap<Integer, Integer> nMap;
        int total;

        public Set() {
            map = new HashMap<String, Integer>();
            nMap = new HashMap<Integer, Integer>();
            parent = new ArrayList<Integer>();
            rank = new ArrayList<Integer>();
            total = 0;
        }

        void makeSet(String s) {
            if (!map.containsKey(s)) {
                map.put(s, total);
                parent.add(total);
                rank.add(0);
                nMap.put(total, 1);
                total++;
            }
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                int totalFriend = nMap.get(px) + nMap.get(py);
                nMap.put(px, totalFriend);
                nMap.put(py, totalFriend);
            }
            if (rank.get(px) > rank.get(py)) {
                parent.set(py, px);
            } else {
                parent.set(px, py);
            }
            if (rank.get(px) == rank.get(py)) {
                rank.set(py, rank.get(py) + 1);
            }
        }

        int find(int x) {
            if (x != parent.get(x)) {
                parent.set(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
    }
}