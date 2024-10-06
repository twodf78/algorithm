import java.util.*;
import java.io.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet();
        List<String> strList = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(strList, (a,b)->a.length() - b.length());
        for(int i = 0; i<strList.size(); i++){
            String source = strList.get(i);
            for(int j = 1; j<= source.length(); j++){
                if(set.contains(source.substring(0, j))) return false;
            }
            set.add(source);
        }
        return true;
    }
}