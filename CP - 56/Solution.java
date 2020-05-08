import java.io.*;
import java.util.*;

public class Solution {
    
    static int N;
    static Code[] codes;
    static char[] enc, text;
    static TreeSet<String> set;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcase = 1;
        StringBuilder sb = new StringBuilder();

        while(scan.hasNextLine()){
            int words = scan.nextInt();
            if(words == 0){
                break;
            }
            codes = new Code[words];
            for(int i = 0; i < words; i++){
                codes[i] = new Code(scan.next().charAt(0), scan.next().toCharArray());
            }
            enc = scan.next().toCharArray();
            N = enc.length;
            text = new char[N + 1];
            set = new TreeSet<String>();
            bt(0, 0, false);
            sb.append("Case #" + testcase++ + "\n");
            int count = 0;
            for(String s: set){
                if(count++ == 100){
                    break;
                }else{
                    sb.append(s);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static class Code implements Comparable<Code>{
        char c;
        char[] s;

        Code(char c, char[] s){ 
            this.c = c; 
            this.s = s; 
        }
        public int compareTo(Code code){ 
            return c - code.c; 
        }
    }
    
    static void bt(int idx, int len, boolean skipped){
        if(idx == N){
            if(!skipped){
                text[len] = '\n';
                set.add(new String(Arrays.copyOf(text, len + 1)));                
            }
            return;
        }
        for(Code code: codes){
            if(enc[idx] == code.s[0]){
                if(code.s.length == 1){
                    text[len] = code.c;
                    bt(idx + 1, len + 1, false);                    
                }else if(idx < N - 1 && enc[idx+1] == code.s[1]){
                    text[len] = code.c;
                    bt(idx + 2, len + 1, false);
                }
            }
        }
        if(!skipped && enc[idx] == '0'){
            bt(idx + 1, len, true);
        }
    }
}