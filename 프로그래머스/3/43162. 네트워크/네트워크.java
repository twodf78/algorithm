import java.util.*;
class Solution {
    Integer[] parent;
    List<List<Integer>> map;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new Integer[n];
        map = new ArrayList<>();
        for(int i = 0; i<computers.length; i++){
            parent[i] = -1;
            List<Integer> currentList = new ArrayList<>();
            
            for(int j = 0 ; j<n; j++){
                if(computers[i][j] == 1){
                    currentList.add(j);
                }
            }
            map.add(currentList);
        }
        
        for(int i = 0; i< n; i++){
            if(parent[i] > 0){
                continue;
            }
            boolean[] visit = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            dfs(queue, visit, computers);
            for(int j = 0; j< n; j++){
                if(visit[j]){
                    parent[j] = i;
                }
            }
        }
        
        HashSet<Integer> ans = new HashSet<>();
        
        for(int j = 0 ; j<n; j++){
            ans.add(parent[j]);
        }
        return ans.size();
    }
    public void dfs(Queue<Integer> queue, boolean[] visit, int[][] computers) {
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            List<Integer> nextList = map.get(current);
            for(Integer next :nextList ){
                if(visit[next]){
                    continue;
                }
                visit[next] = true;
                queue.add(next);
            }
        }
    }


}