package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void edit(int id, Song song);

    void delete(Song song);
}
