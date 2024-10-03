class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long p = 0;
        long m = 0;
        
        for(int i = 0; i<sequence.length; i++){
            int s = sequence[i];
            if( i == 0){
                p = s;
                m = -s;
            }else if(i % 2 == 0){
                p = Math.max(s, p + s);
                m = Math.max(-s, m - s);
            }else{
                p = Math.max(-s, p - s);
                m = Math.max(s, m + s);
            }
            answer = Math.max(answer, Math.max(p, m));
        }
        return answer;
    }
}