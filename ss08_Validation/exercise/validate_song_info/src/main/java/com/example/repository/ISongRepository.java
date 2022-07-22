package com.example.repository;

import com.example.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song, Integer> {

    @Modifying
    @Query(value = "select * from song ", nativeQuery = true)
    List<Song> findAll();

    @Modifying
    @Query(value = "insert into song (nameSong, singer, kindOfMusic, pathFile) values (:nameSong, :singer, :kindOfMusic, :pathFile)", nativeQuery = true)
    void save(@Param("nameSong") String nameSong, @Param("singer") String singer, @Param("kindOfMusic") String kindOfMusic, @Param("pathFile") String pathFile);

    @Modifying
    @Query(value = "select * from song where id = :id ", nativeQuery = true)
    Song findById(@Param("id") int id);

    @Modifying
    @Query(value = "update song set nameSong = :nameSong, singer = :singer, kindOfMusic = :kindOfMusic, pathFile = :pathFile where id = :id", nativeQuery = true)
    void edit(@Param("nameSong") String nameSong, @Param("singer") String singer, @Param("kindOfMusic") String kindOfMusic, @Param("pathFile") String pathFile, @Param("id") int id);

    @Modifying
    @Query(value = "delete from song where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);
}
