package Programmers;

import java.util.*;

class BestAlbum {
    class Song implements Comparable<Song> {
        private String genre;
        private int plays;
        private int songNumber;

        public int getSongNumber() {
            return songNumber;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlays() {
            return plays;
        }

        public Song(String genre, int plays, int songNumber) {
            this.genre = genre;
            this.plays = plays;
            this.songNumber = songNumber;
        }

        // 오름차순 정렬 현재 객체가 우선순위
        @Override
        public int compareTo(Song o) {
            // 만약에 재생수가 같다면 고유넘버를 기준으로 내림차순으로 정렬한다.
            if (o.getPlays() == this.getPlays()) return this.getSongNumber() - o.getSongNumber();
            else return o.getPlays() - this.getPlays();
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Song> songs = new ArrayList<>();
        HashMap<String, Integer> genrePlays = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            songs.add(new Song(genres[i], plays[i], i));
            // 해당장르가 추가가 안되었다면 plays[i]를 넣고 추가가 이미 되어있다면 plays[i]를 더한 것을 저장한다.
           genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        // songs 정렬
        Collections.sort(songs, (o1, o2) -> {
            // 먼저 장르가 같다면 재생수를 비교해서 오름차순으로 정렬한다.
            if (o1.getGenre().equals(o2.getGenre()))
                return o1.compareTo(o2);
            // 장르가 같지 않다면 장르의 총 재생수를 비교해서 오름차순으로 정렬한다.
            else {
                return genrePlays.get(o2.getGenre()) - genrePlays.get(o1.getGenre());
            }
        });

        // 정답리스트
        ArrayList<Integer> answerList = new ArrayList<>();
        // 앨범 이름, 앨범에 들어있는 곡 갯수
        HashMap<String, Integer> album = new HashMap<>();
        for (Song song : songs) {
            // 앨범에 장르가 포함되어 있지 않다면
            if (!album.containsKey(song.getGenre())) {
                // 앨범에 장르를 넣고 곡갯수를 1로 넣는다.
                album.put(song.getGenre(), 1);
                // 정답리스트에 곡 고유 번호 추가
                answerList.add(song.getSongNumber());
            }
            // 앨범에 장르가 포함되어 있다면
            else {
                // 해당 장르의 곡 갯수
                int genreCnt = album.get(song.getGenre());
                // 해당 장르의 곡 갯수가 2를 넘어간다면 더이상 해당 장르앨범에 곡를 추가하지 않는다.
                if (genreCnt >= 2) continue;
                else {
                    // 곡 갯수가 2를 넘어가지 않는다면 곡갯수 추가 및 정답리스트에 곡 고유 번호 추가
                    album.put(song.getGenre(), genreCnt + 1);
                    answerList.add(song.getSongNumber());
                }
            }
        }

   int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        String[] genres = {"a", "b", "z", "a", "a", "a"};
        int[] plays = {500, 150, 2500, 800, 2500, 2500};
        int[] answer = bestAlbum.solution(genres, plays);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

