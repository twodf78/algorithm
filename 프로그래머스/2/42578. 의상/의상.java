import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< clothes.length; i++){
            String[] clothesTuple = clothes[i];
            Integer count = map.getOrDefault(clothesTuple[1], 0);
            map.put(clothesTuple[1], count + 1);
        }
        int answer = 1;
        for(Integer val : map.values()){
            answer *= (val+1);
        }
        return answer - 1;
    }
}