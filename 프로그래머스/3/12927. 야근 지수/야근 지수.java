import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Integer[] wList = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(wList, (a, b) -> b - a);
        
        long cnt = 0;
        for(int idx = 0; idx<wList.length; idx++){
            cnt += (long) wList[idx];
        }
        if(cnt <= n) return 0;
        
        
        int i = 0;
        Integer prev = null;
        while(n > 0){
            if(prev != null && prev >= wList[i]){
                i = 0;
                wList[i]-=1;
                prev = wList[i];
            }else{
                wList[i]-=1;
                prev = wList[i];
            }
            i++;
            if(i >= works.length ){
                i = 0;
            }
            n--;
        }
        for(int idx = 0; idx<wList.length; idx++){
            answer+=Math.pow(wList[idx] , 2);
        }
        return answer;
    }
}