import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] dp = new int[n + 1];
        for(int i = 1; i<=n;i++){
            dp[i] = 1;
        }
        for(int i =0; i<lost.length; i++){
            dp[lost[i]]--;
        }
        for(int i =0; i<reserve.length; i++){
            dp[reserve[i]]++;
        }
        
        for(int i = 1; i<= n;i++){
            if(dp[i] == 0){
                if(i-1>=1 && dp[i-1]==2){
                    dp[i] = 1;
                    dp[i-1]--;
                }
                else if (i+1<=n && dp[i+1]==2){
                    dp[i] = 1;
                    dp[i+1]--;
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i<= n;i++){
            if(dp[i] > 0){
                answer++;
            }
        }
        return answer;
    }
}