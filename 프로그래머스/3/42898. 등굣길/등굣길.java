import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<puddles.length; i++){
            int[] p = puddles[i];
            dp[p[0]][p[1]] = -1;
        }
        for(int i = m; i>=1; i--){
            for(int j = n; j>=1;j--){
                if(dp[i][j]< 0){
                    dp[i][j] = 0;
                    continue;
                }
                //끝점
                if(i==m && j==n){
                    dp[i][j] = 1;
                    continue;
                }
                //제일 우측
                else if(i==m  && j< n){
                    dp[i][j] =  dp[i][j + 1];
                }
                //제일 하단
                else if(i<m && j==n){
                    dp[i][j] =  dp[i+1][j];
                }
                //그 외
                else{
                    dp[i][j] =  (dp[i+1][j] + dp[i][j + 1])%1000000007;
                }
            }
        }
        

        
        return dp[1][1];
    }
}


