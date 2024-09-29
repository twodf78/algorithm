import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<number.length(); i++){
            Integer num = Integer.parseInt(number.substring(i, i+1));
            while(!stack.isEmpty() && k>0 && stack.peek() < num){
                k--;
                stack.pop();
            }
            stack.push(num);
        }
        for(Integer s : stack){
            answer += String.valueOf(s);
        }
        return answer.substring(0, answer.length()-k);
    }
}