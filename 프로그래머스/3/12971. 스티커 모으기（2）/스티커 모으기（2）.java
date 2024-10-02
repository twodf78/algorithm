class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        if(n == 1)return sticker[0];
        if(n == 2)return Math.max(sticker[0], sticker[1]);
        if(n == 3)return Math.max(sticker[0], Math.max(sticker[1], sticker[2]));
        
        int[] front= new int[n + 2];
        int[] rear= new int[n + 2];
        

        for(int i = 2; i<n + 1; i++){
            front[i] = Math.max(front[i-1], front[i-2] + sticker[i-2]);
        }


        for(int i = 3; i<n + 2; i++){
            rear[i] = Math.max(rear[i-1], rear[i-2] + sticker[i-2]);
        }

        
        return Math.max(front[n], rear[n + 1]);
    }
}