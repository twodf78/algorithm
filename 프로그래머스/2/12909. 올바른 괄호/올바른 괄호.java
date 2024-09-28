import java.util.*;
import java.io.*;
class Solution {
    boolean solution(String s) {
        Stack<String> stack= new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            String c = s.substring(i, i+1);
            
            if(c.equals("(")){
                stack.push("(");
            }else{
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }
            
        }

        return stack.empty();
    }
}