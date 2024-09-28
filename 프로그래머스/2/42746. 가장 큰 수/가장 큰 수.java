import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNum = Arrays.stream(numbers).boxed().map(x->x.toString()).toArray(String[]::new);
        List<String> list = new ArrayList<>(Arrays.asList(strNum));
        
        Collections.sort(list, (a, b)->{
            Integer aInt = Integer.parseInt(a + b);
            Integer bInt = Integer.parseInt(b + a);
            return bInt - aInt;        
        });
        
        String num= list.stream().reduce("", (acc, x) -> acc+ x);
        if(num.substring(0, 1).equals("0")){
            return "0";
        }
        return num;
    }
}