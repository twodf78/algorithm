import java.util.*;
import java.io.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> set = new HashSet();
        List<String> phoneBook = new ArrayList<>(Arrays.asList(phone_book));
        
        Collections.sort(phoneBook, (a, b) -> a.length() - b.length());
        
        for(String phone: phoneBook){
            for(int i = 1; i<= phone.length(); i++){
                if(set.contains(phone.substring(0, i))){
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
    }
}