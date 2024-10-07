import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< participant.length; i++){
            Integer count = map.getOrDefault(participant[i], 0);
            map.put(participant[i], count + 1);
        }
        
        for(int i = 0; i< completion.length; i++){
            Integer count = map.get(completion[i]);
            if(count == 1){
                map.remove(completion[i]);
                continue;
            }
            map.put(completion[i], count - 1);
        }
        
        String answer = "";
        for(String ans : map.keySet()){
            answer = ans;
        }
        return answer;
    }
}