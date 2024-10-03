import java.util.*;
import java.io.*;
import java.util.stream.*;
class Job{
    public int start;
    public int realStart;
    public int need;
    
    Job(int start, int realStart, int need){
        this.start= start;
        this.realStart= realStart;
        this.need= need;
    }
    @Override
    public String toString(){
        return "start:" + start + " realStart:" + realStart + " need:" + need;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b)->a.need-b.need);
        HashMap<Integer, List<Job>> map = new HashMap<>();
        Integer max = Collections.max(Arrays.asList(jobs).stream().map((x)->x[1]).collect(Collectors.toList()));

        for(int[] job: jobs){
            Job jobObject = new Job(job[0], -1, job[1]);
            List<Job> jobList = map.getOrDefault(job[0], new ArrayList<>());
            jobList.add(jobObject);
            map.put(job[0],jobList);
        }
        
        Job currentJob = null;
        for(int i = 0; i<=max* jobs.length;i++){
            
            //아무것도 없을 때
            if(pq.isEmpty() && currentJob == null){
                List<Job> jobList = map.get(i);
                if(jobList != null){
                    for(Job job: jobList){
                        pq.add(job);
                    }
                    pq.peek().realStart = i;
                }
                continue;
            }
            
            if(currentJob==null){
                currentJob = pq.poll();
            }
            boolean done = false;
            
            //작업 끝내기
            if(currentJob.realStart + currentJob.need == i){
                answer += i - currentJob.start;
                done = true;
                currentJob = null;
            }
            
            
            List<Job> jobList = map.get(i);
            //이번에 들어오는 게 있을때
            if(jobList != null){
                for(Job job: jobList){
                    pq.add(job);
                }
            }
            
            //현재 자리 차지하는게 없을 때, 바꿔주기
            if(done && !pq.isEmpty()){
                pq.peek().realStart = i;
            }
        }
        
        return (int)Math.floor(answer/jobs.length);
    }
}