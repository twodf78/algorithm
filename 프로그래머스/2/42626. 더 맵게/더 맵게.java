import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< scoville.length; i++){
            pq.add(scoville[i]);
        }
        int count = 0;
        while(!pq.isEmpty() && pq.peek() < K){
            Integer first = pq.poll();
            if(pq.isEmpty()) return -1;
            Integer second = pq.poll();
            pq.add(first + second * 2);
            count++;
        }
        return count;
        
    }
}