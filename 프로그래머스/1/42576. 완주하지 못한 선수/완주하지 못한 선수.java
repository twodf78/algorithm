import java.util.*;
import java.util.Map.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i<participant.length; i++){
            Integer count = map.getOrDefault(participant[i], 0);
            map.put(participant[i], count + 1);
        }
        for(int i = 0 ; i<completion.length; i++){
            Integer count = map.getOrDefault(completion[i], 0);
            map.put(completion[i], count - 1);
        }
        for(Entry entry: map.entrySet()){
            if((Integer)entry.getValue() == 1){
                return (String)entry.getKey();
            }
        }
        return "";
    }
}