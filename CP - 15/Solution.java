import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        double currSpeed = 0;
        int lastHour = 0; 
        int lastMin = 0; 
        int lastSecond = 0;
        double distance = 0;
        while ((s = br.readLine())!= null) {
            StringTokenizer st = new StringTokenizer(s);
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
            int currHour = Integer.parseInt(st2.nextToken());
            int currMin = Integer.parseInt(st2.nextToken());
            int currSecond = Integer.parseInt(st2.nextToken());
            
            int tempHour = currHour;
            //Case for another day.
            if (currHour < lastHour || (currHour == lastHour && currMin < lastMin) || (currHour == lastHour && currMin == lastMin && currSecond < lastSecond)) {
                tempHour = tempHour + 24;
            }
            distance = distance + currSpeed * ((tempHour-lastHour) * 3600 + (currMin - lastMin) * 60 + (currSecond -lastSecond));

            if (st.hasMoreTokens()) {
                currSpeed = Integer.parseInt(st.nextToken())/3600.0;
            } else {
                System.out.printf("%s %.2f km\n", s, distance);
            }
            lastHour = currHour;
            lastMin = currMin;
            lastSecond = currSecond;
        }
    }
}