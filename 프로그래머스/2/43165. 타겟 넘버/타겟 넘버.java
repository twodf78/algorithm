import java.util.*;
class Solution {
    int count = 0;
    int t;
    public int solution(int[] numbers, int target) {
        t = target;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numbers[0]);
        queue.add(-numbers[0]);
        bfs(0, queue, numbers);
        return count;
    }
    public void bfs(int idx, Queue<Integer> queue, int[] numbers) {
        while(!queue.isEmpty()){
            idx++;
            Queue<Integer> newQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                Integer sum = queue.poll();
                if(idx == numbers.length){
                    if(sum == t) count++;
                    continue; 
                }
                newQueue.add(sum + numbers[idx]);
                newQueue.add(sum - numbers[idx]);
            }
            if(idx < numbers.length){
                queue = newQueue;
            }
        }
    }
}