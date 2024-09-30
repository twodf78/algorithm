import java.util.*;
class Solution {
    public int solution(int[] money) {
        int len = money.length + 2;
        
        int[] front = new int[len];
        int[] back = new int[len];
        
        
        for(int i = 2; i< len - 1; i++){
            front[i] = Math.max(front[i-1], front[i-2] + money[i-2]);
        }
        for(int i = 3; i< len; i++){
            back[i] = Math.max(back[i-1], back[i-2] + money[i-2]);
        }
        
        return Math.max(front[len-2], back[len-1]);
    }
}