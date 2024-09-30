import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int[][] triangle) {
        Integer[] dp = new Integer[triangle[triangle.length - 1].length];
        dp[0] = triangle[0][0];
        for(int i = 1; i< triangle.length; i++){
            Integer[] tempDp = new Integer[triangle[i].length];
            for(int idx = 0; idx< tempDp.length; idx++){
                tempDp[idx] = dp[idx];
            }
            
            for(int j = 0; j<triangle[i].length; j++){
                if(j - 1< 0){
                    dp[j] = tempDp[j]  + triangle[i][j];
                }
                else if(j == triangle[i].length - 1){
                    dp[j] = tempDp[j - 1]  + triangle[i][j];
                }else{
                    dp[j] = Math.max(tempDp[j-1]  + triangle[i][j], tempDp[j]  + triangle[i][j]);
                }
            }
        }
        return Collections.max(Arrays.asList(dp));
    }
}