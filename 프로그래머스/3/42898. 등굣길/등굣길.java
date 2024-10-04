import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        dp[m][n] = 1;

        for(int i = 0; i<puddles.length; i++){
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        for(int i = m; i>=1 ; i--){
            for(int j = n; j>=1 ; j--){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == m && j < n){
                    dp[i][j] = dp[i][j+1];
                }else if(i < m && j == n){
                    dp[i][j] = dp[i+1][j];
                }else if(i < m && j < n){
                    dp[i][j] = ( dp[i+1][j] + dp[i][j+1] ) % 1000000007;
                }
            }
        }
        return dp[1][1];
    }
}


