package com.example.service.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void edit(int id, Song song) {
        songRepository.edit(id, song);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }
}
