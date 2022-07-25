package com.example.repository;

import com.example.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface ISongRepository extends JpaRepository<Song, Integer> {

    @Query(value = "select * from song ", nativeQuery = true)
    List<Song> findAll();

    @Modifying
    @Query(value = "insert into song(name_song, singer, kind_of_music, path_file) values (:nameSong, :singer, :kindOfMusic, :pathFile)", nativeQuery = true)
    void save(@Param("nameSong") String nameSong, @Param("singer") String singer, @Param("kindOfMusic") String kindOfMusic, @Param("pathFile") String pathFile);

    @Query(value = "select * from song where id = :id ", nativeQuery = true)
    Optional<Song> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update song set name_song = :nameSong, singer = :singer, kind_of_music = :kindOfMusic, path_file = :pathFile where id = :id", nativeQuery = true)
    void edit(@Param("nameSong") String nameSong, @Param("singer") String singer, @Param("kindOfMusic") String kindOfMusic, @Param("pathFile") String pathFile, @Param("id") Integer id);

    @Query(value = "delete from song where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);
}
