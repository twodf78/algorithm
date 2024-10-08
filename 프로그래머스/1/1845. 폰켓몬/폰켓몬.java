import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i = 0; i<nums.length;i++){
            set.add(nums[i]);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}