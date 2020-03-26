import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int numberOfWords = Integer.parseInt(data[0]);
            int linesPerPage = Integer.parseInt(data[1]);
            int charPerLine = Integer.parseInt(data[2]);
            
            String[] words = scan.nextLine().split(" ");
            int lines = 0;
            int remainingCharacters = 0;
            
            for(int  i = 0; i < numberOfWords; i++){
                int current = words[i].length();
                if(current > remainingCharacters){
                    remainingCharacters = charPerLine;
                    lines++;
                }
                remainingCharacters = remainingCharacters - (current + 1);
            }
            System.out.println((lines + linesPerPage - 1) / linesPerPage);
        }
    }
}