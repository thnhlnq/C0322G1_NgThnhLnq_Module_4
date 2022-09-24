package com.example.repository;

import com.example.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IDanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}
