package com.example.repository.employee;

import com.example.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
