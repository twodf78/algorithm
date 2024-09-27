import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        HashSet<Integer> set = new HashSet();
        
        for(Integer num: nums){
            set.add(num);
        }
        
        return answer < set.size() ? answer : set.size();
    }
}