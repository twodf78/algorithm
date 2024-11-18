import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int i = 0; i<sizes.length; i++){
            int[] size = sizes[i];
            w = Math.max(Math.max(size[0],size[1]), w);
            h = Math.max(Math.min(size[0],size[1]), h);
        }
        return w*h;
    }
}