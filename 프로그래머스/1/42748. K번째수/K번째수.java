import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        Integer[] array_ = Arrays.stream(array).boxed().toArray(Integer[]::new);
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(array_));
        
        
        for(int idx = 0; idx<commands.length; idx++){
            int i = commands[idx][0] - 1;
            int j = commands[idx][1];
            int k = commands[idx][2] - 1;
            
            List<Integer> part = new ArrayList<>(arrayList.subList(i, j));
            Collections.sort(part);
            answer[idx] = part.get(k);
        }
        return answer;
    }
}