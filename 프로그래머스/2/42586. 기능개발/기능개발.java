import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i< progresses.length; i++){
            queue.add(i);
        }
        int time = 0;
        
        while(!queue.isEmpty()){
            int count = 0;
            int idx= queue.peek();
            int timeNeed = (int) Math.ceil((double)(100 - progresses[idx] - speeds[idx] * time) / speeds[idx]);
            time += timeNeed;
            
            while(!queue.isEmpty() && progresses[queue.peek()] + time * speeds[queue.peek()] >= 100){
                count++;
                if(queue.isEmpty())break;
                queue.poll();
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}