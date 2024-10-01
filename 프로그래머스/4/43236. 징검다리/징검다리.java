import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int r = rocks.length;
        Arrays.sort(rocks);
        
        long[] interval = new long[r + 1];
        interval[0] = (long)rocks[0];
        interval[r] = distance - rocks[r - 1];
        
        for(int i = 1; i<r; i++){
            interval[i] = rocks[i] - rocks[i - 1];
        }
        
        long min = 0;
        long max = (long) distance;
        while(min <= max){
            long mid = (min + max) /2;
            if(isAble(mid, interval, n)){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
            
        }
        
        return (int)max;
    }
    public boolean isAble(long mid, long[] interval, int n) {
        //count 는 간격 중에 현재 mid 값보다 낮은 애의 갯수
        int count = n;
        
        for(int i = 0; i<interval.length; i++){
            long current = interval[i];
            if(current >= mid) continue;
            while(current < mid){
                count--;
                if(i<interval.length - 1){
                    i++;
                    current += interval[i];
                }else{
                    break;
                }
                if(count < 0) break;
            }
        }
        
        return count >= 0;
    }
}