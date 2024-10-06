import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    static int[] dx = {1, -1,  0,  0};
    static int[] dy = {0,  0,  1, -1};
    
    int n;
    int m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visit = new int[n][m];
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.add(new int[]{0, 0});
        visit[0][0] = 0;
        
        bfs(queue, maps, visit, 0);
        
        return answer == Integer.MAX_VALUE? -1 : answer;
    }    
    public void bfs(Queue<int[]> queue, int[][] maps, int[][] visit, int count) {
        while(!queue.isEmpty()){
            count++;
            Queue<int[]> newQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                int[]current = queue.poll();
                int pi = current[0];
                int pj = current[1];
                

                if(pi == n-1 && pj == m-1){
                    answer = Math.min(answer, count);
                    return;
                }

                for(int d = 0; d<4; d++){
                    int i = pi + dx[d];
                    int j = pj + dy[d];

                    if(!isValid(i, j)) continue;
                    if(maps[i][j] == 0) continue;
                    if(visit[i][j] <= count) continue;

                    visit[i][j] = count;
                    newQueue.add(new int[]{i, j});
                }
            }
            if(!newQueue.isEmpty()){
                queue = newQueue;
            }else{
                return;
            }
        }
    }
    public boolean isValid(int i , int j){
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}