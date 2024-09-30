import java.util.*;
class Solution {
    int answer = -1;
    int[][] di = new int[4][2];

    int h = 0;
    int w = 0;
    public int solution(int[][] maps) {
        h = maps.length;
        w = maps[maps.length - 1].length;
            
        for(int i = 0; i<4 ;i++){
            if(i%2 == 0){
                di[i][0] = 0;
                di[i][1] = i>1? 1 : -1;
            }else{
                di[i][0] = i>1? 1 : -1;
                di[i][1] = 0;
            }

            
        }
        
        boolean[][]visit = new boolean[h][w];
        visit[0][0] = true;
        Queue<int[]> queue =new LinkedList<>();
        queue.add(new int[]{0,0});
        bfs(0, queue, visit, maps);


        return answer;
    }
    public void bfs(int count, Queue<int[]> queue, boolean[][]visit, int[][] maps) {
        while(!queue.isEmpty()){
            Queue<int[]> newQueue =new LinkedList<>();
            count++;
        
            while(!queue.isEmpty()){
                int[] val = queue.poll();
                for(int d = 0; d< 4 ;d++){
                    int i = val[0] + di[d][0];
                    int j = val[1] + di[d][1];


                    //도달했을때
                    if(i == h -1 && j == w - 1){
                        answer = count + 1;
                        return;
                    }
                    //index 초과
                    if(i < 0 || j < 0 || i> h-1 || j > w - 1){
                        continue;
                    }

                    //이미 방문했거나, 방문하지 못할 때
                    if(visit[i][j] || maps[i][j] == 0){
                        continue;
                    }

                    visit[i][j]= true;
                    newQueue.add(new int[]{i,j});
                }
            }
            if(newQueue.isEmpty()){
                break;
            }else{
                queue = newQueue;
            }
        }
        return;
    }
}