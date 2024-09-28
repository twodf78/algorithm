import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;  // 경과 시간
        int onBridgeWeight = 0;  // 현재 다리 위에 있는 트럭들의 총 무게
        Queue<Integer> bridge = new LinkedList<>();  // 다리 위에 있는 트럭의 남은 이동 시간
        Queue<Integer> waitingTrucks = new LinkedList<>();  // 대기 중인 트럭의 무게 큐

        // 대기 중인 트럭들을 모두 큐에 넣기
        for (int truck : truck_weights) {
            waitingTrucks.add(truck);
        }

        // 초기 다리 상태 (비어있음)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);  // 초기에는 0으로 다리를 채움
        }

        // 다리 위에 트럭이 없을 때까지 반복
        while (!waitingTrucks.isEmpty() || onBridgeWeight > 0) {
            answer++;  // 시간 경과

            // 다리 위의 트럭이 한 칸씩 이동하고 다리를 건넌 트럭 제거
            onBridgeWeight -= bridge.poll();

            // 대기 중인 트럭이 다리로 진입할 수 있는지 확인
            if (!waitingTrucks.isEmpty()) {
                int nextTruck = waitingTrucks.peek();
                if (onBridgeWeight + nextTruck <= weight) {
                    // 트럭을 다리에 올림
                    bridge.add(nextTruck);
                    onBridgeWeight += nextTruck;
                    waitingTrucks.poll();  // 다리에 올라간 트럭은 대기 큐에서 제거
                } else {
                    // 트럭이 다리에 오를 수 없으면 빈칸 추가
                    bridge.add(0);
                }
            } else {
                // 대기 트럭이 없으면 빈칸 추가
                bridge.add(0);
            }
        }

        return answer;
    }
}
