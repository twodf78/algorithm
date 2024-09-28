import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int passedTime = 0;
        
        for(int i = 0; i<speeds.length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            
            int progressNeeded = 100 - (progress + speed * passedTime);
            int timeNeeded = (int) Math.ceil((double) progressNeeded / speed);
            
            passedTime += timeNeeded;
            int cicd = 1;
            for(int j = i+1; j<speeds.length; j++){
                if(progresses[j] + speeds[j] * passedTime >= 100){
                    cicd++;
                    i++;
                }else{
                    break;
                }
            }
            answer.add(cicd);
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}