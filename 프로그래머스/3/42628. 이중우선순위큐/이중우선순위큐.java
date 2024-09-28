import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
       
        PriorityQueue<Integer> pqreverse = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int add = 0;
        int minus = 0;
        
        
        for(String operation: operations){
            String cmd = operation.split(" ")[0];
            Integer num = Integer.parseInt(operation.split(" ")[1]);
            if(cmd.equals("I")){
                pq.add(num);
                pqreverse.add(num);
                add++;
            }else{
                minus++;
                if(add <= minus){
                    pq.clear();
                    pqreverse.clear();
                    minus =0;
                    add=0;
                    continue;
                }
                if(num < 0){
                    int min = pq.poll();
                    pqreverse.remove(min);
                }else{
                    int max = pqreverse.poll();
                    pq.remove(max);
                }
            }
        }

        
        if(add > minus){
            answer[0] = pqreverse.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}