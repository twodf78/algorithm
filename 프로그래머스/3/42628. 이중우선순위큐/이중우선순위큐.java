import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; // 결과를 담을 배열
       
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqreverse = new PriorityQueue<>(Collections.reverseOrder());
        
        int add = 0; // 추가된 숫자의 개수
        int minus = 0; // 삭제된 숫자의 개수
        
        for (String operation : operations) {
            String cmd = operation.split(" ")[0];
            Integer num = Integer.parseInt(operation.split(" ")[1]);
            
            if (cmd.equals("I")) {
                pq.add(num);
                pqreverse.add(num);
                add++;
            } else {
                minus++;
                if (add <= minus) {
                    pq.clear();
                    pqreverse.clear();
                    add = 0; // 초기화
                    minus = 0; // 초기화
                    continue;
                }
                if (num < 0) {
                    int min = pq.poll();
                    pqreverse.remove(min);
                } else {
                    int max = pqreverse.poll();
                    pq.remove(max);
                }
            }
        }

        // 결과를 answer 배열에 할당
        if (add > minus) {
            answer[0] = pqreverse.poll(); // 최대값
            answer[1] = pq.poll(); // 최소값
        }
        return answer;
    }
}
