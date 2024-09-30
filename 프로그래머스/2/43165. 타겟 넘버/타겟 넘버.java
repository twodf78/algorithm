import java.util.*;
class Solution {
    int answer = 0;
    int targetNum ;
    public int solution(int[] numbers, int target) {
        targetNum = target;
        dfs(0, 0, numbers);
        return answer;
    }
    public void dfs(int idx, int num, int[] numbers) {
        if(idx == numbers.length){
            if(targetNum == num ){
                answer++;
            }
            return;
        }
        dfs(idx + 1, num + numbers[idx], numbers);
        dfs(idx + 1, num - numbers[idx], numbers);
    }
}