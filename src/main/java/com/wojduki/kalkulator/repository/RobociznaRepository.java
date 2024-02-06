package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Robocizna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RobociznaRepository extends JpaRepository<Robocizna, Long> {
}
