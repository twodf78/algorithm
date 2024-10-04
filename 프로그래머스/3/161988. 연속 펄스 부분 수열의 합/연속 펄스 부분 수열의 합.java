class Solution {
    public long solution(int[] sequence) {
        long ans = 0;
        long p = 0;
        long m = 0;
        
        for(int i = 0; i< sequence.length; i++){
            int val = sequence[i];
            if(i ==0){
                p = val;
                m = -val;
            }else if(i % 2 == 0){
                p = Math.max(val, p + val);
                m = Math.max(-val, m - val);
            }else{
                p = Math.max(-val, p - val);
                m = Math.max(val, m + val);
            }
            ans = Math.max(ans, Math.max(p, m));
        }
        return ans;
        
    }
}