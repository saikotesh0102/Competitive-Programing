import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcases = Integer.parseInt(scan.nextLine());
        int[] value = new int[27];
        int k = 1;
        for(int i = 0; i < 26; i++){
            value[i] = k;
            k = (k + 1) % 9;
            if(k == 0){
                k = 9;
            }
        }
        int[] vowels = new int[]{'A','U','E','O','I'};
        int[] vowel_array = new int[105];
        for(int i = 0; i < vowels.length; i++){
            for(int j = 0; j < 21; j++){
                vowel_array[j + 21 * i] = vowels[i] - 'A';
            }
        }
        int[] cons_array = new int[105];
        k = 0;
        for(int val = 1; val < 10; val++){
            for(int i = 0; i < 26; i++){
                if(!isVowel(i,vowels) && value[i] == val){
                    for(int j = 0; j < 5; j++){
                        cons_array[k++] = i;
                    }
                }
            }
        }
        for(int i = 1; i <= testcases; i++){
            sb.append("Case " + i + ": ");
            int n = Integer.parseInt(scan.nextLine());
            int[] cons = new int[n/2];
            for(int j = 0; j < cons.length; j++){
                cons[j] = cons_array[j];
            }
            int[] vowel = new int[(n + 1)/2];
            for(int j = 0; j < vowel.length; j++){
                vowel[j] = vowel_array[j];
            }
            Arrays.sort(vowel);
            Arrays.sort(cons);
            int l = 0, m = 0;
            for(int cur = 1; cur <= n; cur++){
                if(cur % 2 == 0){
                    sb.append((char)(cons[l++] + 'A'));
                }else{
                    sb.append((char)(vowel[m++] + 'A'));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    static boolean isVowel(int k, int[] vowels){
        for(int i = 0; i < 5; i++){
            if(vowels[i] - 'A' == k){
                return true;
            }
        }
        return false;                
    }
}