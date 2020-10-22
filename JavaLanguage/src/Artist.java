import java.util.ArrayList;

//Artist는 여러 앨범을 가지고 있고 앨범들은 여러 곡들을 가지고 있다.

public class Artist {
    private String artistName;
    // 여러 앨범들을 가지는 ArrayList
    ArrayList<Album> albums = new ArrayList<>();

    // 생성자 인수 : artistName
    public Artist(String artistName){
        this.artistName = artistName;
    }

    // 앨범 추가 메소드
    public void addAlbum(Album album){
        albums.add(album);
    }

    // 앨범 getter
    public ArrayList<Album> getAlbums(){
        return this.albums;
    }
    // 앨범 이름 getter
    public String getArtistName(){
        return this.artistName;
    }


}
