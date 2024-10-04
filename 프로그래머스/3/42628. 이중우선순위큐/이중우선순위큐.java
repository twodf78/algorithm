import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int n = operations.length;
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(int i = 0; i< n; i++){
            String[] op = operations[i].split(" ");
            if(op[0].equals("I")){
                max.add(Integer.parseInt(op[1]));
                min.add(Integer.parseInt(op[1]));
            }else{
                if(Integer.parseInt(op[1]) > 0){
                    Integer val = max.poll();
                    min.remove(val);
                }else{
                    Integer val = min.poll();
                    max.remove(val);
                }
            }
        }
        return max.isEmpty() ? new int[]{0,0} : new int[]{max.peek(), min.peek()};
    }
}
