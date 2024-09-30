import java.util.*; 
class Solution {
    int answer = Integer.MAX_VALUE;
    String targetFinal;
    int n ;
    int [][] dp;
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        targetFinal = target;
        dp = new int[n][n];
        
        for(int i = 0; i<n; i++){
            String a = words[i];
            for(int j = i + 1; j<n; j++){
                String b = words[j];
                if(isConvertable(a,b)){
                    dp[i][j] = 1;
                    dp[j][i] = 1;
                }
            }
            
        }

        
        for(int i = 0; i<n; i++){
            if(isConvertable(begin,words[i])){
                boolean[] visit = new boolean[n];
                Queue<Integer> idxQueue = new LinkedList<>();
                idxQueue.add(i);
                visit[i] = true; 
                bfs(idxQueue, visit, words);
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void bfs(Queue<Integer> idxQueue, boolean[] visit, String[] words){
        int cnt = 1;
        while(!idxQueue.isEmpty()){
            Queue<Integer> newQueue = new LinkedList<>();
            while(!idxQueue.isEmpty()){
                Integer idx = idxQueue.poll();
                
                if(words[idx].equals(targetFinal)){
                    answer = Math.min(answer, cnt);
                    break;
                }
                for(int i = 0; i<n;i++){
                    if(i == idx || visit[i] || dp[i][idx]!=1){
                        continue;
                    }
                    newQueue.add(i);
                    visit[i] = true; 
                }
            }
            if(newQueue.isEmpty()){
                break;
            }
            idxQueue = newQueue;
            cnt++;
        }
        return;
    }
    
    public boolean isConvertable(String a, String b){
        int count = 0;
        for(int i = 0; i< a.length(); i++){
            String ca= a.substring(i, i+1);
            String cb= b.substring(i, i+1);
            if(!ca.equals(cb)){
                count++;
            }
            if(count >= 2){
                return false;
            }
        }
        return count == 1;
    }
}