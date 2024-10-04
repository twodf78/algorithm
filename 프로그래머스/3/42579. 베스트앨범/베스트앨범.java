import java.util.*;
import java.io.*;
class Genre{
    public int total;
    public List<int[]> musicList;
    
    public Genre(){
        this.total = 0;
        this.musicList = new ArrayList();
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i< plays.length ; i++){
            String genre = genres[i];
            int play = plays[i];
            
            Genre entity = map.getOrDefault(genre, new Genre());
            if(entity.musicList.isEmpty()){
                map.put(genre, entity);
            }
            entity.musicList.add(new int[]{play, i});
            entity.total+=play;
        }
        
        Set<String> keySet= map.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList, (a, b)->map.get(b).total - map.get(a).total);
        
        for(String key: keyList){
            List<int[]> musicList = map.get(key).musicList;
            Collections.sort(musicList, (a, b)->b[0] - a[0]);
            for(int i = 0; i< Math.min(2, musicList.size()); i++){
                
                ans.add(musicList.get(i)[1]);
            }
        }
        return ans.stream().mapToInt(x->x).toArray();
        
    }
}