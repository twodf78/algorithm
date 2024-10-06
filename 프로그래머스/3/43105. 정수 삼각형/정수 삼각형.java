import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int[][] triangle) {
        int n =triangle.length; 
        int[] dp = new int[triangle[n-1].length];
        dp[0] = triangle[0][0];
        for(int i = 1; i< triangle.length; i++){
            int[] row = triangle[i];
            int[] temp = new int[row.length - 1];
            for(int j = 0; j< row.length - 1; j++){
                temp[j] = dp[j];
            }
            for(int j = 0; j< row.length; j++){
                if(j == 0){
                    dp[j] = temp[j] + row[j];
                }else if(j == row.length - 1){
                    dp[j] = temp[j - 1] + row[j];
                }else{
                    dp[j] = Math.max(temp[j - 1] + row[j], temp[j] + row[j]);
                }
            }
        }
        Integer[] dpInteger = Arrays.stream(dp).boxed().toArray(Integer[]::new);
        List<Integer> dpList = new ArrayList<>(Arrays.asList(dpInteger));
        return Collections.max(dpList);
    }
}