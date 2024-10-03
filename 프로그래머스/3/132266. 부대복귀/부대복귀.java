import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] dp = new int[n + 1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i<n + 1; i++){
            dp[i] = i == destination ? 0 : Integer.MAX_VALUE;
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i<roads.length; i++){
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i<sources.length;i++){
            queue.add(new int[]{destination, 0});
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int node = current[0];
                int cost = current[1];

                List<Integer> nextList = map.get(node);
                for(Integer next : nextList){
                    if(dp[next] != Integer.MAX_VALUE){
                        continue;
                    }else{
                        dp[next] = Math.min(dp[next], cost + 1);
                    }
                    queue.add(new int[]{next, cost + 1});
                }
            }
            
        }


        
        int[] answer = new int[sources.length];
        for(int i = 0; i<sources.length;i++){
            answer[i] = dp[sources[i]] == Integer.MAX_VALUE ? -1 : dp[sources[i]];
        }
        return answer;
    }
}