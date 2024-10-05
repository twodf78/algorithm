import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i< clothes.length;i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            
            Integer count = map.getOrDefault(type, 0);
            map.put(type, count + 1);
        }
        int answer =1;
        for(Integer count: map.values()){
            answer*= count + 1;
        }
        return answer - 1;

    }
}