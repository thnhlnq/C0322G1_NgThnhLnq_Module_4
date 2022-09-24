package com.example.repository;

import com.example.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ITinTucRepository extends JpaRepository<TinTuc, Integer> {

    @Query(value = "select * from tin_tuc where tieu_de like :nameFind", nativeQuery = true)
    Page<TinTuc> findAll(Pageable pageable, @Param("nameFind") String nameFind);
}
