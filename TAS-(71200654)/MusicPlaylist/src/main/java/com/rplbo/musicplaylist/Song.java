package com.rplbo.musicplaylist;
public class Song {
    private String artis;
    private String album;
    private String name;
    private int length;

    public Song(String name, String artis, String album, int length) {
        this.artis = artis;
        this.album = album;
        this.name = name;
        this.length = length;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

