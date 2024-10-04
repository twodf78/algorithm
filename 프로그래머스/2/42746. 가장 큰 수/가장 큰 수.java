import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public String solution(int[] numbers) {
        String[] nums= Arrays.stream(numbers).boxed().map(x->x.toString()).toArray(String[]::new);
        List<String> list = new ArrayList<>(Arrays.asList(nums));
        Collections.sort(list, (a,b)->Integer.parseInt(b+a) - Integer.parseInt(a+b));
        
        if(list.get(0).equals("0")) return "0";
        String ans = "";
        for(String str: list){
            ans+=str;
        }
        return ans;
    }
}