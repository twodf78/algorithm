import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>(List.of(phone_book));
        
        Collections.sort(list, (a, b)->a.length() - b.length());
        for(int i = 0 ; i< list.size(); i++){
            String phone = list.get(i);
            for(int j = 1; j<= phone.length(); j++){
                if(set.contains(phone.substring(0, j))){
                    return false;
                }
            }
            set.add(phone);
        }
        return true;

    }
}