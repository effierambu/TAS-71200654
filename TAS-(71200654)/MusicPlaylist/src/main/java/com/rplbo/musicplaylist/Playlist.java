package com.rplbo.musicplaylist;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private static ArrayList<Song> songs = new ArrayList<Song>(6);
    private int count;

    public Playlist() {}

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlayListName(String playlistName) {
        this.playlistName = playlistName;
    }

    public static void print() {
        System.out.println("Jumlah lagu = " + songs.size() + " / Kapasitas Playlist = 6");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println("ListSong[" + i + "] : " + songs.get(i).getName() + " - " + songs.get(i).getArtis());
        }
        System.out.println();
    }

    public String totalTime() {
        for (int i = 0; i < songs.size(); i++) {
            this.count += songs.get(i).getLength();
        }
        return "Total waktu [" + this.playlistName + "] = " + this.count + " detik";
    }

    public void add(Song song) {
        if(this.songs.size() == 6) {
            System.out.println("Playlist " + this.playlistName + " penuh!. Tidak bisa menambahkan lagu lagi.");
        } else {
            this.songs.add(song);
        }
    }

    public Song remove(String nama) {
        for (int i = 0; i < songs.size(); i++) {
            if(songs.get(i).getName().equals(nama)) {
                System.out.println(songs.get(i).getName() + " terhapus...");
                songs.remove(i);
            }
        }
        return null;
    }

    public int size() {
        return this.songs.size();
    }
}


