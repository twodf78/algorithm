import java.util.*;
class Solution {
    Integer[] parent;
    Integer start;
    List<List<Integer>> map = new ArrayList<>();
    public int solution(int n, int[][] computers) {
        parent = new Integer[n];
        
        for(int i = 0 ; i< n; i++){
            parent[i] = i;
            List<Integer> connected = new ArrayList<>();
            for(int j = 0 ; j< n; j++){
                if(computers[i][j] == 1 && i != j) connected.add(j);
            }
            map.add(connected);
        }
        for(int i = 0; i< n; i++){
            if(parent[i] != i) continue;
            boolean[] visit = new boolean[n];
            visit[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            start = i;
            bfs(queue, computers, visit);
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i<n; i++){
            set.add(parent[i]);
        }
        return set.size();
    }
    public void bfs(Queue<Integer> queue, int[][] computers, boolean[] visit){
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            List<Integer> nextList = map.get(current);
            if(nextList == null) continue;
            for(Integer next: nextList){
                if(visit[next]) continue;
                visit[next] = true;
                queue.add(next);
                parent[next] = start;
            }
        }
        
    }

}