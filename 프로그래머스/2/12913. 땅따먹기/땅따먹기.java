import java.util.*;
import java.util.stream.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int [][] dp = new int[land.length][4];
        for(int i = 0; i<4;i++){
            dp[0][i] = land[0][i]; 
        }
        
        for(int j = 1; j< land.length; j++){
            for(int i = 0; i<4;i++){
                int idx1 = (i + 1) % 4;
                int idx2 = (i + 2) % 4;
                int idx3 = (i + 3) % 4;
                dp[j][i] = land[j][i] + Math.max(dp[j-1][idx1], Math.max(dp[j-1][idx2], dp[j-1][idx3])); 
            }
        }

        Integer[] ans = Arrays.stream(dp[dp.length-1]).boxed().toArray(Integer[]::new);
        return Collections.max(new ArrayList<>(Arrays.asList(ans)));
    }
}