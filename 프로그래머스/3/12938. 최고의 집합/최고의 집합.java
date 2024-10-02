import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};
        int[] answer = new int[n];
        int baseNum = (int)Math.floor((double) s/ n);
        for(int i = 0; i< n;i++){
            answer[i] = baseNum;
        }
        int dif = s - n*baseNum;
        while(dif > 0){
            answer[n-dif]++;
            dif--;
        }
        
        
        
        return answer;
    }
}