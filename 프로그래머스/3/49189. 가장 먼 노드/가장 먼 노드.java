import java.util.*;
import java.util.stream.*;
class Solution {
    List<List<Integer>> list = new ArrayList(); 
    boolean[] visit; 
    public int solution(int n, int[][] edge) {
        visit = new boolean[n+1];
        
        for(int i = 0; i<= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edge.length; i++){
            int[] e = edge[i];
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        return bfs(queue, 0);
    }
    public int bfs(Queue<Integer> queue, int prevCount) {
        Queue<Integer> newQueue = new LinkedList<>();
        int count = 0;
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            List<Integer> next = list.get(current);
            
            for(Integer n: next){
                if(visit[n]){
                    continue;
                }
                newQueue.add(n);
                visit[n] = true;
                count++;
            }
        }
       
        return newQueue.isEmpty() ? prevCount : bfs(newQueue, count);
    }
}