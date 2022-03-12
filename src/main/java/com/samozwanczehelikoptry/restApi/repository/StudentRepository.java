package com.samozwanczehelikoptry.restApi.repository;

import com.samozwanczehelikoptry.restApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
