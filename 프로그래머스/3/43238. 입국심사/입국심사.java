import java.util.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long)times[0] *n;
        
        while(min <= max){
            long mid = (long)Math.floor((long)(min+max) / 2);
            if(isAble(mid, n, times)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean isAble(long mid, int n, int[] times) {
        long count = 0;
        for(int i = 0; i< times.length;i++){
            int t = times[i];
            count += (long)Math.floor((long)mid / t);
            if(count >= n){
                return true;
            }
        }
        return false;
    }
}