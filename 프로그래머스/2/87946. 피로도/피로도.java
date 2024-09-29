import java.util.*;
import java.io.*;
import java.util.stream.*;
class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        for(int i = 0; i<dungeons.length; i++){
            boolean[] visit = new boolean[dungeons.length];
            if(dungeons[i][0] > k){
                continue;
            }
            visit[i] = true;
            dfs(k - dungeons[i][1], dungeons, visit, 1);
        }
        return answer;
    }
    public void dfs(int k, int[][] dungeons, boolean[] visit, int count) {
        for(int i = 0; i<dungeons.length; i++){
            if(visit[i]){
                continue;
            }
            if(dungeons[i][0] > k){
                continue;
            }
            visit[i] = true;
            dfs(k - dungeons[i][1], dungeons, visit, count + 1);
            visit[i] = false;
        }
        answer = Math.max(count, answer);
    }
}