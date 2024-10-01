import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    List<HashSet<Integer>> win = new ArrayList<>();
    List<HashSet<Integer>> lose = new ArrayList<>();
    public int solution(int n, int[][] results) {
        int answer = 0;
        for(int i = 0; i<= n;i++){
            win.add(new HashSet<>());
            lose.add(new HashSet<>());
        }
        
        
        for(int i = 0; i< results.length;i++){
            int[] r = results[i];
            win.get(r[0]).add(r[1]);
            lose.get(r[1]).add(r[0]);
        }
        
        for(int i = 1; i<= n ;i++){
            Queue<Integer> winQueue = new LinkedList<>();
            Queue<Integer> loseQueue = new LinkedList<>();
            
            winQueue.add(i);
            loseQueue.add(i);
            
            bfs(i, winQueue, new boolean[n+1], true);
            bfs(i, loseQueue, new boolean[n+1], false);
            
            if (win.get(i).size() + lose.get(i).size() >= n - 1){
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int start, Queue<Integer> queue, boolean[] visit, boolean isWin) {
        
        while(!queue.isEmpty()){
            Integer c = queue.poll();
            visit[c] = true;
            
            HashSet<Integer> next = isWin ? win.get(c) : lose.get(c);
            for(Integer ne : next){
                if(visit[ne]) continue;
                
                if(isWin){
                    win.get(start).add(ne);
                }else{
                    lose.get(start).add(ne);
                }
                queue.add(ne);
            }
        }
    }
    
}