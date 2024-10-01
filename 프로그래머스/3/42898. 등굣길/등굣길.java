import java.util.*;
class Solution {
    int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m+1][n+1];
        
        for(int i = 0; i<puddles.length;i++){
            int[] p = puddles[i];
            dp[p[0]][p[1]] = -1;
        }
        dp[m][n] = 1;
        for(int i = m; i>0; i--){
            for(int j = n ; j>0; j--){
                if(dp[i][j] < 0){
                    dp[i][j] = 0;
                    continue;
                }if(i == m && j< n){
                    dp[i][j] = dp[i][j+1];
                }else if(i < m && j == n){
                    dp[i][j] = dp[i + 1][j];
                }else if(i < m && j < n){
                    dp[i][j] = (dp[i + 1][j] + dp[i][j+1]) % 1000000007;
                }
            }
        }
        return dp[1][1];
    }
}


