import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("E", 1);
        map.put("I", 2);
        map.put("O", 3);
        map.put("U", 4);
        for(int i = 0; i< word.length(); i++){
            String c = word.substring(i, i+1);
            answer += (int)cal(4- i) * map.get(c) + 1;
        }
        return answer;
    }
    public int cal(int place){
        int num = 0;
        for(int i = 0; i<=place; i++){
            num+= Math.pow(5, i);
        }
        return num;
    }
}