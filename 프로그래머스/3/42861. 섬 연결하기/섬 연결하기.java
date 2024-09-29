import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    int [] dp;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        dp = new int[n];
        Arrays.sort(costs, (a, b)->a[2] - b[2]);
        
        for(int i =0; i< n; i++){
            dp[i] = i;
        }
        for(int i = 0; i<costs.length; i++){
            int[] cost = costs[i];
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            if(!isParent(a, b)){
                unionParent(a, b);
                answer+=c;
            }
            
        }
        return answer;
    }
    public boolean isParent(int a, int b){
        return findParent(a) == findParent(b);
    }
    public int findParent(int node){
        return dp[node] == node ? node : findParent(dp[node]);
    }
    public void unionParent(int a, int b){
        int ap = findParent(a);
        int bp = findParent(b);
        if(ap<= bp){
            dp[bp] = ap;
        }else{
            dp[ap] = bp;
        }
    }
}