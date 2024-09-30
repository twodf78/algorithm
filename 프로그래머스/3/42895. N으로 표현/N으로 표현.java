import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i< 8; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(Integer.parseInt(String.valueOf(N).repeat(i + 1)));
            
            for(int j = 0; j<i; j++){
                for(Integer jVal : list.get(j)){
                    for(Integer pVal : list.get(i-j-1)){
                        set.add(jVal + pVal);
                        set.add(jVal - pVal);
                        set.add(jVal * pVal);
                        if(pVal!=0){
                            set.add(jVal / pVal);
                        }
                    }         
                }
            }
            
            if(set.contains(number)){
                return i+1;
            }
            list.add(set);
        }
        return -1;
    }
}