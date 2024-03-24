package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}
