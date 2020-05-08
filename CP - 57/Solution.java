import java.io.*;
import java.util.*;

public class Solution {
    
    static String data;
    static int idx;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            data = scan.nextLine();
            if(data.equals("0")){
                break;
            }
            idx = 0;
            boolean tautology = true;
            Node root = build();
            for(int i = 0; i < 32; i++){
                if(!root.evaluate(i)){
                    tautology = false;
                }
            }
            if(tautology){
                System.out.println("tautology");
            }else{
                System.out.println("not");
            }
        }
    }
    
    static Node build(){
        Node cur = new Node(data.charAt(idx++));
        if(!(cur.c >= 'p' && cur.c <= 't')){
            cur.left = build();
            if(cur.c != 'N'){
                cur.right = build();
            }
        }
        return cur;
    }
    
    static class Node{
        char c;
        Node left; 
        Node right;

        Node(char c){ 
            this.c = c; 
        }

        public boolean evaluate(int val){
            if(c >= 'p' && c <= 't'){
                return (val & (1 << c - 'p')) != 0;
            }
            if(c == 'K'){
                return left.evaluate(val) && right.evaluate(val);
            }
            if(c == 'A'){
                return left.evaluate(val) || right.evaluate(val);
            }
            if(c == 'N'){
                return !left.evaluate(val);
            }
            if(c == 'C'){
                return !left.evaluate(val) || right.evaluate(val);
            }
            return left.evaluate(val) == right.evaluate(val);
        }
    }
}