import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int N, int number) {
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i = 1; i<=8; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for(int j = 0; j< i - 1; j++){
                HashSet<Integer> jSet = list.get(j);
                HashSet<Integer> kSet = list.get(i - 1 - j - 1);
                for(Integer jVal : jSet){
                    for(Integer kVal: kSet){
                        set.add(jVal + kVal);
                        set.add(jVal - kVal);
                        set.add(jVal * kVal);
                        if(kVal!=0){
                            set.add(jVal / kVal);
                        }
                    }
                }
            }
            if(set.contains(number)) return i;
            list.add(set);
        }
        return -1;
    }
}