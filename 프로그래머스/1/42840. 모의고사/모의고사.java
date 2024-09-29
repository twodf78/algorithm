import java.util.*;
import java.util.stream. *;
import java.io.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[answers.length];
        int[] second = new int[answers.length];
        int[] third = new int[answers.length];
        
        int[] secondSample = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdSample = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int firstAnswer = 0;
        int secondAnswer = 0;
        int thirdAnswer = 0;

        List<Integer> answer = new ArrayList<>();
        for(int i =0; i<answers.length; i++){
            int ans = answers[i];
            first[i] = i % 5 + 1;
            second[i] = secondSample[i%8];
            third[i] = thirdSample[i%10];
            
            if(ans == first[i]){
                firstAnswer++;
            }            
            if(ans == second[i]){
                secondAnswer++;
            }            
            if(ans == third[i]){
                thirdAnswer++;
            }
        }
        
        int max = Math.max(firstAnswer, secondAnswer);
        max = Math.max(max, thirdAnswer);
        if(firstAnswer == max){
            answer.add(1);
        }
        if(secondAnswer == max){
            answer.add(2);
        }
        if(thirdAnswer == max){
            answer.add(3);
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}