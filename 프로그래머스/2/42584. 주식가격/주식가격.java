import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];
        
        for(int i = 0; i< n ; i++){
            int price = prices[i];
            
            int count = 0;
            while(!stack.isEmpty() && stack.peek()[0] > price){
                int[] current = stack.pop();
                answer[current[1]] = i - current[1]; 
            }
            stack.push(new int[]{price, i});
        }
        
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            answer[current[1]] = n - current[1] - 1; 
        }
        
        return answer;
    }
}