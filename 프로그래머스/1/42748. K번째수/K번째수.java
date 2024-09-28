import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        List<Integer> list = new ArrayList<>(Arrays.asList(integerArray));
        for(int idx = 0; idx< commands.length; idx++){
            int[] cmd = commands[idx];
            int i = cmd[0];
            int j = cmd[1];
            int k = cmd[2];
            List<Integer> part = new ArrayList<>(list.subList(i - 1, j)); // 부분 리스트 추출
            Collections.sort(part);
            answer[idx] = part.get(k - 1);
            
        }
        return answer;
    }
}