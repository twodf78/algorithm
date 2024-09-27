import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completeMap = new HashMap<>();
        for(String p : participant){
            Integer num = completeMap.get(p);
            if(num == null){
                completeMap.put(p, 1);
            }else{
                completeMap.put(p, num + 1);
            }
        }
        for(String p : completion){
            Integer num = completeMap.get(p);
            if(num-1 == 0){
                completeMap.remove(p);
            }else{
                completeMap.put(p, num - 1);
            }
        }
        
        for(Map.Entry<String, Integer> entry: completeMap.entrySet()){
            answer = entry.getKey();
        }
        
        return answer;
    }
}