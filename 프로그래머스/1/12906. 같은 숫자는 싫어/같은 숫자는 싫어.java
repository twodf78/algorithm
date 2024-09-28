import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        

        for(int i =0; i<arr.length; i++){
            int val = arr[i];
            if(stack.empty()){
                stack.push(val);
            }else{
                if(stack.peek()!=val){
                    stack.push(val);
                }
            }
        }
        
        
        return stack.stream().mapToInt(x->x).toArray();
    }
}