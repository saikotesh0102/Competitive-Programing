import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long operation(long input1, long input2, char operation){
        switch(operation){
            case '*': 
                return input1 * input2;
            default: 
                return input1 + input2;
        }
    }
    
    public static long compute(String data, boolean min){
        Stack<Character> operations = new Stack<Character>();
        Stack<Long> numbers = new Stack<Long>();
        String result = "";
        
        for(int i = 0; i < data.length(); i++){
            char c = data.charAt(i);
            if(c >= '0' && c <= '9'){
                result = result + c;
            }
            else{
                numbers.push(Long.parseLong(result));
                result = "";
                if(c == '+'){
                    if(!min){
                        while(!operations.isEmpty() && operations.peek() == '+'){
                            numbers.push(operation(numbers.pop(),numbers.pop(),operations.pop()));
                        }
                    }else{
                        while(!operations.isEmpty()){
                            numbers.push(operation(numbers.pop(),numbers.pop(),operations.pop()));
                        }
                    }
                    operations.push(c);
                }else{
                    if(min){
                        while(!operations.isEmpty() && operations.peek() == '*'){
                            numbers.push(operation(numbers.pop(),numbers.pop(),operations.pop()));
                        }
                    }else{
                        while(!operations.isEmpty()){
                            numbers.push(operation(numbers.pop(),numbers.pop(),operations.pop()));
                        }
                    }
                    operations.push(c);
                }
            }
        }
        numbers.push(Long.parseLong(result));
        while(!operations.isEmpty()){
            numbers.push(operation(numbers.pop(),numbers.pop(),operations.pop()));
        }
        return numbers.pop();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < testcases; i++){
            String data = scan.nextLine();
            long min = compute(data,true);
            long max = compute(data,false);
            System.out.println("The maximum and minimum are " + max + " and " + min + ".");
        } 
    }
}