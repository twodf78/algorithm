import java.util.*;
class Solution
{
    static String s;
    public int solution(String s)
    {
        this.s=s;
        int max = s.length();
        while(max > 0){
            for(int i = 0; i< s.length() - max + 1; i++){
                if(reversible(i, i+max - 1)){
                    return max;
                }
            }
            max--;
        }
        return max;
    }
    public boolean reversible(int start, int end){
        while(start <= end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}