package com.example.service.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void edit(Song song) {
        songRepository.edit(song.getNameSong(), song.getSinger(), song.getKindOfMusic(), song.getPathFile(), song.getId());
    }

    @Override
    public void delete(Integer id) {
        songRepository.delete(id);
    }
}
