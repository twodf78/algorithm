import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<int[]>> playMap = new HashMap<>();
        
        for(int i = 0 ; i< plays.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            Integer count = genreMap.getOrDefault(genre, 0);
            genreMap.put(genre, count + play);
                        
            List<int[]> playList = playMap.getOrDefault(genre, new ArrayList<>());
            if(playList.isEmpty()){
                playMap.put(genre, playList);
            }
            playList.add(new int[]{play, i});
        }
        
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        
        Collections.sort(genreList, (a, b) -> genreMap.get(b) -genreMap.get(a));
        
        List<Integer> answer= new ArrayList<>();
        for(String genre: genreList){
            List<int[]> playList = playMap.get(genre);
            Collections.sort(playList, (a, b) -> b[0] - a[0]);
            for(int i = 0; i< Math.min(2, playList.size()); i++){
                answer.add(playList.get(i)[1]);
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}