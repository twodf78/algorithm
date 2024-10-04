import java.util.*;
class Solution {
    HashMap<String, List<Integer>> map;
    boolean[] visit;
    int n;
    List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        n = tickets.length;
        visit = new boolean[n];
        for(int i = 0; i< n; i++){
            String[] ticket = tickets[i];
            List<Integer>idxList = map.getOrDefault(ticket[0], new ArrayList<>());
            if(idxList.isEmpty()){
                map.put(ticket[0],idxList);
            }
            idxList.add(i);
        }
        
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(answer);
        return answer.get(0).split(" ");
        
    }
    public void dfs(String current, String route, String[][] tickets, int count) {
        if(count == n){
            answer.add(route);
            return;
        };
        List<Integer> next = map.get(current);
        if(next == null){
            return;
        }
        for(Integer n: next){
            if(visit[n]) continue;
            visit[n] = true;
            dfs(tickets[n][1], route + " " + tickets[n][1], tickets, count + 1);
            visit[n] = false;
        }
        
    }
}