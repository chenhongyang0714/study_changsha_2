package com.study.vo;

public class Music {
    private String album; // 专辑名
    private String albumpic;  //专辑图片
    private String name; // 歌曲名
    private String artist;//歌手名
    private String songTimeMinutes;//歌曲的时长
    private String playUrl; // 歌曲加载链接
    private String movieUrl; // mv 链接

    public Music() {

    }

    public Music(String album, String albumpic, String name, String artist, String songTimeMinutes, String playUrl, String movieUrl) {
        this.album = album;
        this.albumpic = albumpic;
        this.name = name;
        this.artist = artist;
        this.songTimeMinutes = songTimeMinutes;
        this.playUrl = playUrl;
        this.movieUrl = movieUrl;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumpic() {
        return albumpic;
    }

    public void setAlbumpic(String albumpic) {
        this.albumpic = albumpic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTimeMinutes() {
        return songTimeMinutes;
    }

    public void setSongTimeMinutes(String songTimeMinutes) {
        this.songTimeMinutes = songTimeMinutes;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    @Override
    public String toString() {
        return "Music{" +
                "album='" + album + '\'' +
                ", albumpic='" + albumpic + '\'' +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", songTimeMinutes='" + songTimeMinutes + '\'' +
                ", playUrl='" + playUrl + '\'' +
                ", movieUrl='" + movieUrl + '\'' +
                '}';
    }
}
