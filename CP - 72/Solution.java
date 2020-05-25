import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            char[] t = scan.nextLine().toCharArray();
            Stack<Character> s = new Stack<Character>();
            int i = 0, j = 1;
            boolean ok = true;
            while(i < t.length){
                char c = t[i];
                if(c == '[' || c == '{' || c == '<' || c == '('){
                    if(c == '(' && i < t.length - 1 && t[i+1] == '*'){
                        c = '*'; 
                        ++i;
                    }
                    s.push(c);
                }
                else if(c == ']' || c == '}' || c == ')' || c == '>' || (c == '*' && i < t.length - 1 && t[i+1] == ')')){
                    if(s.isEmpty()) { 
                        ok = false; 
                        break; 
                    }
                    
                    if(c == '*')
                        ++i;
                    char cc = s.pop();
                    if(c == ']' && cc != '[' || c == '}' && cc != '{' || c == ')' && cc != '(' || c == '>' && cc != '<' || c == '*' && cc != '*'){
                        ok = false;
                        break;
                    }
                    
                }
                ++i; ++j;
            }
            if(!s.isEmpty()){
                ok = false;
            }
            System.out.println(ok ? "YES" : "NO " + j);
        }
    }
}