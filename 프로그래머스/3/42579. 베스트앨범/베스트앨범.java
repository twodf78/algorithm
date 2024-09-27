import java.util.*;
import java.io.*;
class Music{
    int index;
    int play;
    
    Music(int index, int play){
        this.index = index;
        this.play = play;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList();
        HashMap<String, List<Music>> map = new HashMap<>();
        HashMap<String, Integer> totalMap = new HashMap<>();
        for(int i = 0; i< genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            Music music = new Music(i, play);
            
            List<Music> musicList =  map.get(genre);
            if(musicList == null){
                List<Music> newList = new ArrayList<>();
                newList.add(music);
                map.put(genre, newList);
            }else{
                musicList.add(music);
            }
            
            totalMap.put(genre, totalMap.getOrDefault(genre, 0) + play);
        }
        
        List<String> keyList = new ArrayList<>(totalMap.keySet());
        Collections.sort(keyList, (a, b) -> totalMap.get(b) - totalMap.get(a));
        for(String genre : keyList){
            List<Music> musicList =  map.get(genre);
            Collections.sort(musicList, (a, b) -> b.play - a.play);
            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                ans.add(musicList.get(i).index);
            }
        }
        int[] answer = ans.stream().mapToInt(x->x).toArray();
        return answer;
    }
}