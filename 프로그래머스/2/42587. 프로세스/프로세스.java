import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  b - a);
        Queue<int[]> queue = new LinkedList<>(); 
        for(int i = 0; i< priorities.length ; i++){
            pq.add(priorities[i]);
            queue.add(new int[] {priorities[i], i});
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int[] first = queue.poll();
            if(first[0] == pq.peek()){
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