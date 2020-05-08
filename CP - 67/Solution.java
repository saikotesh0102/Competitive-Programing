import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int N = Integer.parseInt(scan.nextLine());
            if(N == 0){
                break;
            }
            while(scan.hasNextLine()){
                String[] data = scan.nextLine().split(" ");
                if(data[0].equals("0")){
                    break;
                }
                Queue<Integer> queue = new LinkedList<Integer>();
                for(int i = 0; i < N; i++){
                    queue.add(Integer.parseInt(data[i]));
                }
                Stack<Integer> stack = new Stack<Integer>();
                int A = 0;
                while(!queue.isEmpty()){
                    int cur = queue.remove();
                    while((stack.isEmpty() || stack.peek() != cur) && A <= N){
                        stack.push(++A);
                    }
                    if(A > N){
                        break;
                    }
                    stack.pop();
                }
                if(A > N){
                    System.out.println("No");
                }else{
                    System.out.println("Yes");
                }
            }
            System.out.println();
        }
    }
}