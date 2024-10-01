import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    List<HashSet<Integer>> setList = new ArrayList<>();
    public int solution(int N, int number) {
        setList.add(new HashSet<>());
        for(int cnt = 1; cnt <= 8; cnt++){
            HashSet<Integer> set = new HashSet<>();
            set.add(Integer.parseInt(String.valueOf(N).repeat(cnt)));
            for(int i = 1; i< cnt; i++){
                HashSet<Integer> iSet = setList.get(i);
                HashSet<Integer> jSet = setList.get(cnt - i);
                    for(Integer in: iSet){
                        for(Integer jn: jSet){
                            set.add(in + jn);
                            set.add(in - jn);
                            set.add(in * jn);
                            if(jn != 0){
                                set.add(in / jn);
                            }
                        }
                    }
            }
            if(set.contains(number)){
                return cnt;
            }
            setList.add(set);
        }
        
        return -1;
    }
}