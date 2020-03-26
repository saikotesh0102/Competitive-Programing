import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char [] replacement=new char [128];
        for (int i = 0; i < replacement.length; i++) {
            replacement[i] = (char)i;
        }
        String [] data = new String [] {"`1234567890-=", "QWERTYUIOP[]\\",
                                       "ASDFGHJKL;'","ZXCVBNM,./"};
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length(); j++) {
                replacement[data[i].charAt(j)] = data[i].charAt(j - 1);
            }
        }
        String s;
        while ((s = br.readLine())!= null) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0;i < s.length(); i++) {
                sb.append(replacement[s.charAt(i)]);
            }
            System.out.println(sb.toString());
        }
    }
}