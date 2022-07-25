package com.example.service;

import com.example.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {

    List<Song> findAll();

    void save(Song song);

    Optional<Song> findById(Integer id);

    void edit(Song song);

    void delete(Integer id);
}
