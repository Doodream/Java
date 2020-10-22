public class Song {
    private String songName;
    private Artist artist;
    private Album album;

    public Song (){

    }
    // 생성자 인수 : songName, artist, album
    public Song (String songName, Artist artist, Album album){
        this.songName = songName;
        this.artist = artist;
        this.album = album;
    }

    // String toString 오버라이드
    @Override
    public String toString(){
        String answer = this.songName + " - " +this.artist.getArtistName() +"\n"+this.album.getAlbumName()+"("+this.album.getMadeyear()+")";
        return answer;
    }
}

