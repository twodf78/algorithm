import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] count = new int[n];
        for(int i = 0; i<lost.length; i++){
            count[lost[i] - 1]--;
        } 
        for(int i = 0; i<reserve.length; i++){
            count[reserve[i] - 1]++;
        } 
        for(int i = 0; i< n;i++){
            count[i]++;
        }
        for(int i = 0; i< n;i++){
            if(count[i] == 0){
                if(i-1 >= 0 && count[i-1] >= 2){
                    count[i] ++;
                    count[i-1] --;
                }else if(i+1 < n && count[i+1] >= 2){
                    count[i] ++;
                    count[i+1] --;
                } else{
                    continue;
                }
            }
            answer++;
        }
        return answer;
    }
}