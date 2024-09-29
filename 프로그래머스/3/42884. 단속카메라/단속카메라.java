import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b)->a[1] - b[1]);
        
        int[] previous = routes[0];
        
        for(int i = 1; i< routes.length; i++){
            int[] current = routes[i];
            if(previous[1] < current[0]){
                answer++;
                previous = current;
            }
        }
        return answer;
    }
}