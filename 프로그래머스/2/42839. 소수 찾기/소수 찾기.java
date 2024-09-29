import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        addToSet("", numbers);
        
        for(Integer num:set){
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public void addToSet(String previous, String numbers) {
        if(!previous.equals("")){
            set.add(Integer.parseInt(previous));
        }        
        
        for(int i = 0; i<numbers.length();i++){
            if(!previous.equals("")){
                set.add(Integer.parseInt(previous));
            }
            addToSet(previous + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, numbers.length()));
        }
    }
    
    public boolean isPrime(Integer num) {
        if(num< 2){
            return false;
        }
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}