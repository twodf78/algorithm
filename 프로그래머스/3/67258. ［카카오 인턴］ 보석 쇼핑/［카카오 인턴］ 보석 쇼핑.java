import java.util.*; 
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int distinctSize = set.size();
        HashMap<String, Integer> map = new HashMap<>();
        
        int l = 0;
        int r = 0;
        map.put(gems[0], 1);
        while(r<gems.length){
            if(map.size() == distinctSize){
                if(answer[1] - answer[0] > r-l){
                    answer = new int[]{l+1,r+1};
                }
                Integer gemCount = map.get(gems[l]);
                if(gemCount - 1 == 0){
                    map.remove(gems[l]);                
                }else{
                    map.put(gems[l], gemCount - 1);
                }
                l++;
            }else{
                r++;
                if(r>=gems.length) break;
                Integer gemCount = map.get(gems[r]);
                map.put(gems[r], gemCount == null ? 1 : gemCount + 1);  
            }
        }
        return answer;
    }
}