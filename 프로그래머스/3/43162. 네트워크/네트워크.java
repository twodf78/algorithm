import java.util.*;
class Solution {
    Integer[] parent;
    public int solution(int n, int[][] computers) {
        parent = new Integer[n];
        for(int i = 0; i< n;i++){
            parent[i]=i;
        }
        for(int i = 0; i< n;i++){
            if(parent[i]!=i) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean[] visit = new boolean[n];
            visit[i] = true;
            bfs(queue, visit, computers);
        }

        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< n;i++){
            set.add(parent[i]);
        }
        return set.size();
    }
    public void bfs(Queue<Integer> queue,boolean[] visit, int[][] computers) {
        Integer parentVal = queue.peek();
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            int[] nextArray = computers[current];
            for(int i = 0; i<nextArray.length;i++){
                int next = nextArray[i] ;
                if(visit[i] || next == 0) continue;
                parent[i] = parentVal;
                visit[i] = true; 
                queue.add(i);
            }
        }
    }

}