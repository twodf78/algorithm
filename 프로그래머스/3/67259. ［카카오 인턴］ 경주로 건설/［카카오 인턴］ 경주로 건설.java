import java.util.*;
class Solution {
    int n;
    int answer = Integer.MAX_VALUE;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(int[][] board) {
        n = board.length; 
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0,100, 0});
        queue.add(new int[]{0,0,100, 2});
        int[][] visit = new int[n][n];
        visit[0][0] = 100;
        bfs(queue, board, visit);
        
        return answer - 100;
    }
    public void bfs(Queue<int[]> queue, int[][] board, int[][] visit){
        
        Queue<int[]> newQueue = new LinkedList();
        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int pi = current[0];
                int pj = current[1];  
                int cost = current[2];
                int prev = current[3];
                
                                  
                if(pi == n-1 && pj== n-1){
                    answer = Math.min(answer, cost);
                }
                
                for(int d = 0; d< 4; d++){
                    int i = pi + dx[d];
                    int j = pj + dy[d];
                    if(!isValid(i, j)||board[i][j] == 1){
                        continue;
                    }
                    
                    int newCost = prev < 0 || prev == d ? cost + 100 : cost + 600;

                    
                    if(visit[i][j]==0 || visit[i][j] + 500 > newCost){
                        newQueue.add(new int[]{i, j, newCost, d});
                        visit[i][j]=newCost;
                    }
                }
            }
            if(!newQueue.isEmpty()){
                queue = newQueue;
            }
        }

    }
    
    public boolean isValid(int i, int j){
        return i>= 0 && j>= 0 && i< n && j < n;
    }
}