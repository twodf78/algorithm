import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n;
    int m;
    int min = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        bfs(maps);
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public void bfs(int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        int[][] visit = new int[n][m];
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        visit[0][0] = 0;
        
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Queue<int[]> newQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                if(i == n-1 && j == m-1){
                    min = Math.min(min, count);
                    return;
                }
                for(int d = 0 ; d< 4; d++){
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    
                    if(!isValid(ni, nj) || maps[ni][nj] == 0 || visit[ni][nj] <= count) continue;
                    visit[ni][nj] = count;
                    newQueue.add(new int[]{ni, nj});
                }
            }
            if(!newQueue.isEmpty()){
                queue = newQueue;
            }else{
                return;
            }
        }
    }
    public boolean isValid(int i, int j){
        return i>= 0 && j>=0 && i<n&& j<m;
    }
}