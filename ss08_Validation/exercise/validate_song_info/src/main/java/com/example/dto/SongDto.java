package com.example.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SongDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nameSong;

    private String singer;

    private String kindOfMusic;

    private String pathFile;

    public SongDto() {
    }

    public SongDto(int id, String nameSong, String singer, String kindOfMusic, String pathFile) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.pathFile = pathFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
