import java.util.*;
import java.io.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int min = 0;
        int max = people.length - 1;
        while(min <= max){
            if(people[min] + people[max] > limit ){
                max --;
            }else{
                min++;
                max--;
            }
            answer++;
        }
        return answer;
    }
}