import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Integer[] integerA = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] integerB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(integerA, (a,b)->b-a);
        Arrays.sort(integerB, (a,b)->b-a);
        
        int b = 0;
        for(int a = 0; a<A.length; a++){
            if(integerB[b] > integerA[a]){
                b++;
            }
        }
        return b;
    }
}