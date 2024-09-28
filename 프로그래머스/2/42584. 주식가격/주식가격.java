import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<List<Integer>>stack = new Stack<>();
        List<Integer> el = new ArrayList<>();
        el.add(prices[0]);
        el.add(0);
        stack.add(el);
        
        for(int i = 1; i< prices.length;i++){
            int price = prices[i];
            if(stack.peek().get(0) <= price){
                List<Integer> e = new ArrayList<>();
                e.add(prices[i]);
                e.add(i);
                stack.add(e);
            }else{
                while(!stack.empty() && stack.peek().get(0) > price){
                    List<Integer> peek = stack.pop();
                    answer[peek.get(1)] = i - peek.get(1);
                }
                List<Integer> e = new ArrayList<>();
                e.add(prices[i]);
                e.add(i);
                stack.add(e);
            }
        }
        while(!stack.empty()){
            List<Integer> peek = stack.pop();
            answer[peek.get(1)] = prices.length - 1- peek.get(1);
        }
        return answer;
    }
}