import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        Queue<int[]> queue = new LinkedList<>(); 
        for(int i = 0; i< priorities.length ; i++){
            pq.add(new int[] {priorities[i], i});
            queue.add(new int[] {priorities[i], i});
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int[] first = queue.poll();
            if(first[0] == pq.peek()[0]){
                pq.poll();
                count++;
                if(first[1] == location) return count;
            }else{
                queue.add(first);
            }
        }
        return count;
    }
}