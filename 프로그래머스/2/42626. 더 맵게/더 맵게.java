import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< scoville.length; i++){
            pq.add(scoville[i]);
        }
        int count = 0;
        while(pq.size() > 0 && pq.peek() < K){
            int first = pq.poll();
            if(pq.size()<=0) return -1;
            int second = pq.poll();
            pq.add(first + second * 2);
            count++;
        }
        return count;
    }
}