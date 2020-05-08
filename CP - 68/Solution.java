import java.io.*;
import java.util.*;

public class Solution {
    
    public static int image [][];
    public static char [] first , second ;
    public static int idx ;
    
    public static void fill (int a , int b , int c , int d , int crntIdx , int arrIdx){
        switch (arrIdx == 0 ? first[crntIdx] : second[crntIdx]){
            case 'p' :
                fill( a + c >> 1 , b          , c          , b + d >> 1 , ++idx , arrIdx);
                fill(a           , b          , a + c >> 1 , b + d >> 1 , ++idx , arrIdx);
                fill(a           , b + d >> 1 , a + c >> 1 , d          , ++idx , arrIdx);
                fill(a + c >> 1  , b + d >> 1 , c          , d          , ++idx , arrIdx);
                break;
            case 'e' : break;
            case 'f' : color(a , b , c , d);
        }
    }
    
    public static void color (int row1 , int col1 , int row2 , int col2){
        for(int i = row1 ; i < row2 ; ++i)
            for (int j = col1 ; j < col2 ; ++j)
                image[i][j] = 1;
    }
    
    public static int count (){
        int cnt = 0;
        for(int i = 0 ; i < 32 ; ++i)
            for(int j = 0 ; j < 32 ; ++j)
                if (image[i][j] == 1) ++cnt;
        return cnt;
    }
    
    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            image = new int[32][32];
            first = sc.next().toCharArray();
            second = sc.next().toCharArray();
            idx = 0; fill(0,0,32,32,idx,0);
            idx = 0; fill(0,0,32,32,idx,1);
            System.out.println("There are " + count () + " black pixels.") ;
        }
    }
}