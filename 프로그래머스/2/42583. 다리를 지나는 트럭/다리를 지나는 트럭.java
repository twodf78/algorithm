import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new LinkedList<>();
        int time = 0; 
        int onWeight = 0; 
        int idx = 0; // 대기 트럭 인덱스
        
        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++; 
            
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                onWeight -= bridge.poll()[0];
            }
            
            // 대기 트럭 중 다음 트럭이 다리로 올라갈 수 있는지 확인
            if (idx < truck_weights.length && onWeight + truck_weights[idx] <= weight && bridge.size() < bridge_length) {
                // [1]에 그냥 언제 나갈 수 있는 지를 집어넣음.
                bridge.add(new int[]{truck_weights[idx], time + bridge_length}); 
                onWeight += truck_weights[idx]; // 다리 위에 올라간 트럭의 무게를 더함
                idx++; // 다음 대기 트럭으로 이동
            }
        }
        
        return time;
    }
}
