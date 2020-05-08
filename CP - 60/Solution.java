import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int rows = 0;
    static int cols = 0;
    static boolean marked[][];
    static int flag = 2;
    static ArrayList<Integer> obj;
    static ArrayList<Integer> temp;
    static int pos = 1, x1 = 1, y1 = 0;
    static ArrayList<Simple> simpleObj;
    
    public static void method(int row, int col, int[][] array) {
        if (row == (rows - 1) && array[row][col] == obj.get(pos - 1)) {
            int flag = 0;
            for (int g = 0; g < simpleObj.size(); g++) {
                if (simpleObj.get(g).x1 == x1 && simpleObj.get(g).y1 == y1 && simpleObj.get(g).x2 == row+1 && simpleObj.get(g).y2 == col+1) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                // System.out.println("Fasak");
                Simple var = new Simple(x1, y1, row+1, col+1);
                simpleObj.add(var);
            }
            return;
        }

        if (index(row + 1, col) && array[row + 1][col] == obj.get(pos) && !marked[row + 1][col]) {
            if (pos == obj.size()-1) {
                flag++;
                for (int i = 0; i < flag; i++) {
                    obj.add(i+1);
                }
                temp.add(obj.size()-1);
            }
            pos++;
            marked[row + 1][col] = true;
            method(row + 1, col, array);
            pos--;
            marked[row + 1][col] = false;
        }
        if (index(row, col + 1) && array[row][col + 1] == obj.get(pos) && !marked[row][col + 1]) {
            if (pos == obj.size()-1) {
                flag++;
                for (int i = 0; i < flag; i++) {
                    obj.add(i+1);
                }
                temp.add(obj.size()-1);
            }
            pos++;
            marked[row][col + 1] = true;
            method(row, col + 1, array);
            pos--;
            marked[row][col + 1] = false;
        }
        if (index(row - 1, col) && array[row - 1][col] == obj.get(pos) && !marked[row - 1][col]) {
            if (pos == obj.size()-1) {
                flag++;
                for (int i = 0; i < flag; i++) {
                    obj.add(i+1);
                }
                temp.add(obj.size()-1);
            }
            pos++;
            marked[row - 1][col] = true;
            method(row - 1, col, array);
            pos--;
            marked[row - 1][col] = false;
        }
        if (index(row, col - 1) && array[row][col - 1] == obj.get(pos) && !marked[row][col - 1]) {
            if (pos == obj.size()-1) {
                flag++;
                for (int i = 0; i < flag; i++) {
                    obj.add(i+1);
                }
                temp.add(obj.size()-1);
            }
            pos++;
            marked[row][col - 1] = true;
            method(row, col - 1, array);
            pos--;
            marked[row][col - 1] = false;
        }
    }
    
    public static boolean index(int row, int col) {
        if (row >=0 && row < rows && col < cols && col >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int loop = scan.nextInt();
        for (int i = 0; i < loop; i++) {
            rows = scan.nextInt();
            cols = scan.nextInt();
            int[][] array = new int[rows][cols];
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    array[j][k] = scan.nextInt();
                }
            }
            simpleObj = new ArrayList();
            for (int q = 0; q < cols; q++) {
                y1 = q+1;
                if (array[0][q] == 1) {
                    marked = new boolean[rows][cols];
                    obj = new ArrayList();
                    temp = new ArrayList();
                    obj.add(1);
                    obj.add(1);
                    obj.add(2);
                    flag = 2;
                    temp.add(0);
                    temp.add(2);
                    marked[0][q] = true;
                    method(0, q, array);
                }
            }
            y1 = 0;
            Collections.sort(simpleObj);
            Simple variable = simpleObj.get(0);
            System.out.println(variable.x1+" "+variable.y1+"\n"+variable.x2+" "+variable.y2);
            if (i != loop - 1) {
                System.out.println();
            }
        }
    }
}

class Simple implements Comparable<Simple>{
    int x1, y1;
    int x2, y2;
    
    Simple (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public int compareTo(Simple that) {
        if (this.y1 < that.y1) {
            return -1;
        } else if (this.y1 > that.y1) {
            return 1;
        } else {
            if (this.y2 < that.y2) {
                return -1;
            } else if (this.y2 > that.y2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}