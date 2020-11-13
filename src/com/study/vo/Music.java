package com.study.vo;

public class Music {
    private String album; // 专辑名
    private String albumpic;  //专辑图片
    private String name; // 歌曲名
    private String artist;//歌手名
    private String duration;//歌曲的时长
    private String playUrl; // 歌曲加载链接

    public Music() {
    }

    public Music(String album, String albumpic, String name, String artist, String duration, String playUrl) {
        this.album = album;
        this.albumpic = albumpic;
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.playUrl = playUrl;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Override
    public String toString() {
        return "Music{" +
                "album='" + album + '\'' +
                ", albumpic='" + albumpic + '\'' +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", duration='" + duration + '\'' +
                ", playUrl='" + playUrl + '\'' +
                '}';
    }
}
