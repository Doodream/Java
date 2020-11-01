import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    class Song implements Comparable<Song> {
        private int plays;
        private int number;
        private String genre;

        public Song(int plays, int number, String genre) {
            this.plays = plays;
            this.number = number;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o) {
            if (this.plays == o.plays) return this.number - o.number;
            else return o.plays - this.plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> genrePlays = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int number = i;
            songs.add(new Song(play, number, genre));
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);
        }

        Collections.sort(songs, ((Song o1, Song o2) -> {
            if (o1.genre.equals(o2.genre)) return o1.compareTo(o2);
            else {
                return genrePlays.get(o2.genre) - genrePlays.get(o1.genre);
            }
        }));
        for (int i = 0; i < songs.size(); i++) {
            System.out.print(songs.get(i).number);
        }
        HashMap<String, Integer> album = new HashMap<>();
        // 장르에 따른 숫자
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            if (album.containsKey(song.genre)) {
                int genreCnt = album.get(song.genre);
                if (genreCnt < 2) {
                    album.put(song.genre, genreCnt + 1);
                    answerList.add(song.number);
                }
            } else {
                album.put(song.genre, 1);
                answerList.add(song.number);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = solution.solution(genres, plays);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}
