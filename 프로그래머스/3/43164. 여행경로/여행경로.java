import java.util.*;
class Solution {
    List<String> ans = new ArrayList<>();
    boolean[] visit;
    int n;
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        visit = new boolean[n];
            
        dfs("ICN","ICN", tickets, 0);        
        Collections.sort(ans);
        return ans.get(0).split(" ");
    }
    public void dfs(String current, String route, String[][] tickets, int count){
        if(count == n){
            ans.add(route);
            return;
        }
        for(int i = 0; i<n; i++){
            String[] t = tickets[i];
            if(!t[0].equals(current) || visit[i]){
                continue;
            }
            visit[i] = true;
            dfs(t[1], route + " " + t[1], tickets, count+1);
            visit[i] = false;
        }
    }
}