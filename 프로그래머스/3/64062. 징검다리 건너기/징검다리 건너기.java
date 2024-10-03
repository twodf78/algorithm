import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        
        int min = 1;
        int max = 200000000;
        
        while(min <= max){
            int mid = ( max + min ) / 2;
            int count = 0;
            for(int i = 0; i< stones.length; i++){
                count = stones[i] - mid <= 0 ? count + 1 : 0;
                if(count == k) break;
            }
            if(count == k){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
            
        return min;
    }
}