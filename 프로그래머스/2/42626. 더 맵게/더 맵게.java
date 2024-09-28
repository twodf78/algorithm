import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.add(s);
        }
        int count = 0;
        while(pq.size()>1){
            if(pq.peek() >= K){
                return count;
            }
            
            Integer smallest = pq.poll();
            Integer smaller = pq.poll();
            pq.add(smaller * 2 + smallest);
            count++;
        }
        return pq.peek() >= K ? count : -1;
    }
}