import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 1;
        int s = 0;
        while(true){
            if(s < stations.length && left >= stations[s] - w ){
                left = stations[s] + w +1;
                s++;
            }else{
                answer++;
                left += 1 + 2 *w;
            }
            
            if(left > n) break;
        }

        return answer;
    }
}