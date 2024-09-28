import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int[] citations) {
        Integer[] intArray = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>(Arrays.asList(intArray));
        
        Collections.sort(list);
        int max = Collections.max(list);
        int h = 0;
        
        int previousPassed = 0;
        while(h<=max){
            int passed = 0;
            int idx = 0;
            while(idx< list.size() ){
                if(h <= list.get(idx)){
                    passed++;
                }
                idx++;
            }
            
            int notpassed = list.size() - passed;
            if(passed >= h && notpassed <= h){
                h++;
                if(h > max){
                    h-=1;
                    break;
                }
            }
            else{
                h--;
                break;
            }
        }
        return h;
    }
}