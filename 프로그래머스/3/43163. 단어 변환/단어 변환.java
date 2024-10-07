import java.util.*; 
class Solution {
    String t;
    int answer = Integer.MAX_VALUE;
    int[][] map; 
    int n;
    public int solution(String begin, String target, String[] words) {
        t = target;
        n = words.length;
        map = new int[n][n + 1];
        
        for(int i = 0; i< n; i++){
            String wi = words[i];
            for(int j = i + 1; j< n; j++){
                String wj= words[j];
                if(isConvertable(wi, wj)){
                    map[i][j] = 1; 
                    map[j][i] = 1; 
                }
            }
            if(isConvertable(wi, target)){
                map[i][n] = 1;
            }
        }
        
        for(int i = 0; i< n; i++){
            String wi = words[i];
            if(isConvertable(wi, begin)){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                boolean[] visit = new boolean[n];
                visit[i] = true;
                bfs(queue, visit, words);
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void bfs(Queue<Integer> queue, boolean[] visit, String[] words) {
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Queue<Integer> newQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                Integer idx = queue.poll();
                if(words[idx].equals(t)){
                    answer = Math.min(answer, count);
                }

                int[] nextList = map[idx];
                for(int i = 0; i< n;i++){
                    int next = nextList[i];
                    if(next == 0 || visit[i]) continue;
                    visit[i] = true;
                    newQueue.add(i);
                }
            }
            if(!newQueue.isEmpty()){
                queue = newQueue;
            }
        }
    }
    public boolean isConvertable(String from, String to) {
        int count = 0;
        for(int i = 0; i< from.length();i++){
            if(from.charAt(i) != to.charAt(i)) count++;
            if(count >= 2) return false;
        }
        return count <= 1;
    }
}