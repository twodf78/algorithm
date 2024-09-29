import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        for(int i =0; i< sizes.length; i++){
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            maxW = maxW < w? w: maxW;
            maxH = maxH < h? h: maxH;
        }
        return maxW * maxH;
        
    }
}