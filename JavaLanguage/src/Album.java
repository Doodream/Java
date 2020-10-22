import java.util.ArrayList;

// 아티스트는 여러 앨범들을 갖고 앨범들은 여러 곡들을 가진다.
public class Album {
    private String albumName;
    private int madeyear;
    private Artist artist;

    // 여러곡을 가지는 Song ArrayList
    ArrayList<Song> songs = new ArrayList<>();

    // 생성자 인수 : albumName, madeYear, artist
    public Album(String albumName, int madeYear, Artist artist){
        this.albumName = albumName;
        this.madeyear = madeYear;
        this.artist = artist;
    }

    // 곡 추가 메소드
    public void addTrack (Song song){
        songs.add(song);
    }
    // Track getter : 인수로 인덱스를 받아 songs 리스트의 곡을 반환
    public Song getTrack (int index){
        return this.songs.get(index - 1);
    }

    // madeYear getter
    public int getMadeyear(){
        return this.madeyear;
    }

    // albumName getter
    public String getAlbumName() {
        return this.albumName;
    }


}
