import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        for(int height = 1; height<= total; height++){
            if(total % height!=0){
                continue;
            }
            
            int width = total / height;
            
            int yellowHeight = height - 2;
            int yellowWidth = width - 2;
            int yellowShape = yellowHeight * yellowWidth;
            
            if(yellowShape == yellow && total - yellowShape == brown){
                answer[0] = width;
                answer[1] = height;
                break;
            }
            
        }
        return answer;
    }
}