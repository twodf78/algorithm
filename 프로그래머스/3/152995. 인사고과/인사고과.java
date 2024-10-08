import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int a = scores[0][0];
        int b = scores[0][1];
        int sum = a + b;
        // 점수를 태도를 기준으로 내림차순, 평가를 기준으로 오름차순 정렬
        Arrays.sort(scores, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
                
        int temp = 0;
        int rank = 1;
        for (int[] score : scores){
            if (a < score[0] && b < score[1]){ // 완호의 점수가 둘 중 한번이라도 적어지면
                return -1; // -1
            }
            
            // 이미 태도 기준으로 내림차순 되어있기에 평가 점수만 고려하면 된다.
            if (temp <= score[1]){
                temp = score[1]; 
                if(score[0] + score[1] > sum){
                    rank++;
                }
            }
        }
        return rank;
    }
}
