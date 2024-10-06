import java.util.*;
import java.io.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] jobs) {
        // 0 - 도착 시간, 1-소요시간 (->실제종료시간)
        PriorityQueue<int[]> ready = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        
        // 0 - 도착 시간, 1-소요시간
        List<int[]> jobList = new ArrayList<>();
        for(int i = 0; i<jobs.length; i++){
            int[] val = jobs[i];
            jobList.add(val);
        }
        
        Collections.sort(jobList, (a, b)->a[0] - b[0]);
        
        int pIdx = 0;
        int answer = 0;
        int[] current = null;
        for(int time = jobList.get(0)[0]; time < jobs.length * 1000; time++){
            
            while(pIdx< jobList.size() && jobList.get(pIdx)[0] <= time){
                ready.add(new int[]{jobList.get(pIdx)[0], jobList.get(pIdx)[1]});
                pIdx++;
            }
            if(current ==null && !ready.isEmpty()){
                current = ready.poll();
                current[1]+=time;
            }
            //현재거 종료
            if(current!=null && current[1] <= time){
                answer += current[1] - current[0];
                
                if(!ready.isEmpty()){
                    current = ready.poll();
                    current[1]+=time;
                }else{
                    current = null;
                }
                
                
            }
            if(ready.isEmpty() && pIdx >= jobList.size() && current == null) break;
        }
        return answer/jobs.length;
    }
}