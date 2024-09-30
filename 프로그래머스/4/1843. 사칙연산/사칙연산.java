import java.util.*;
import java.io.*;
class Solution {
    public int solution(String arr[]) {
        int answer = Integer.MIN_VALUE; 
        
        int numLength = (int)Math.ceil((double)arr.length / 2);
        
        //max[i][j] i 부터 j 까지의 숫자에서 가장 큰 값.
        int[][] max = new int[numLength][numLength];
        int[][] min = new int[numLength][numLength];
        for(int i = 0; i<numLength; i++){
            for(int j = 0; j< numLength; j++){
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
            max[i][i] = Integer.parseInt(arr[i*2]);
            min[i][i] = Integer.parseInt(arr[i*2]);
        }
        //cnt 구간의 길이
        //i 구간의 시작점
        //j 구간의 끝점
        for(int cnt = 1; cnt<numLength; cnt++){
            for(int i = 0; i<numLength - cnt; i++){
                int j = cnt + i;
                for(int k = i; k< j; k++){
                    String cmd = arr[k*2 + 1];
                    if(cmd.equals("+")){
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);                       
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);                       
                    }else{
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);                       
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);    
                    }
                }
            }
        }
        return max[0][numLength - 1];
    }
}