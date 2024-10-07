import java.util.*;
import java.util.stream.*;
class Solution {
    int min = 100;
    int[][] map;
    public int solution(int n, int[][] wires) {
        map = new int[n+1][n+1];
        for(int i = 0; i< wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        
        for(int i = 0; i< wires.length;i++){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            boolean[] visit = new boolean[n+1];
            visit[1] = true;
            bfs(queue, visit, wires[i]);
        }
        return min;
    }
    
    public void bfs(Queue<Integer> queue, boolean[] visit, int[] cut) {
        while(!queue.isEmpty()){
            Integer v = queue.poll();
            int[] nextList = map[v];
            for(int i = 0; i< nextList.length;i++){
                int connected = nextList[i];
                if(visit[i] || connected == 0) continue;
                if( (v == cut[0] && i == cut[1])
                  || (v == cut[1] && i == cut[0])){
                    continue;
                }
                visit[i] = true;
                queue.add(i);
            }
        }
        int visited = 0;
        for(int i = 0 ; i< visit.length; i++){
            if(visit[i]) visited++;
        }
        int dif = Math.abs((visit.length - 1 - visited) - visited);
        min = Math.min(min, dif);
    }
}