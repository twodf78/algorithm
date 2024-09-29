import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    int min = 100;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        for(int i=0; i< wires.length; i++){
            Integer from = wires[i][0] - 1;
            Integer to = wires[i][1] - 1;
            List<Integer> fromList = map.get(from);
            if(fromList == null){
                fromList = new ArrayList<>();
                fromList.add(to);
                map.put(from, fromList);
            }else{
                fromList.add(to);
            }
            
            List<Integer> toList = map.get(to);
            if(toList == null){
                toList = new ArrayList<>();
                toList.add(from);
                map.put(to, toList);
            }else{
                toList.add(from);
            }
        }
        
        for(int i=0; i< wires.length; i++){
            calDif(i, n, wires);
        }
        
        return min;
    }
    public void calDif(int idx, int n, int[][] wires){
        int[] used = wires[idx];
        
        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        
        boolean[] visited = new boolean[n];
        visited[0] = true;

        dfs(used, queue, visited, wires);
        
        int size = 0;
        System.out.print(used[0] - 1+"  ");
        System.out.print(used[1] - 1+"  ");
            System.out.println();
        for(int i = 0 ; i<visited.length; i++){
            
            System.out.println(size);
            System.out.print(visited[i]+" ");
            if(visited[i]){
                size++;
            }
        }
        min = Math.min(min,  Math.abs(size - (n - size)));
    }
    public void dfs(int[] used, Queue<Integer> queue, boolean[] visited, int[][] wires){
        while(!queue.isEmpty()){
            int from = queue.poll();
            List<Integer> toList = map.get(from);
            for(Integer to: toList){
                if(visited[to]){
                    continue;
                }
                if((used[0]-1 == from && used[1]-1 == to)
                   || (used[0]-1 == to && used[1]-1 == from)){
                    continue;
                }
                visited[to] = true;
                queue.add(to);
            }
            dfs(used,queue, visited, wires);
        }
    }
}