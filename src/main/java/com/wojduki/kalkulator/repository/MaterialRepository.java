package com.wojduki.kalkulator.repository;

import com.wojduki.kalkulator.model.Material;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    @Query("select s from Student s where s.lastName = ?1 order by s.lastName")
    List<Material> findByLastNameOrderByLastNameAsc(String lastName, Pageable pageable);

    @Query("select s from Student s where upper(s.lastName) like upper(?1) and upper(s.firstName) not like upper(?2)")
    List<Material> findByLastNameLikeAndFirstNameNotLikeAllIgnoreCase(String lastName, String firstName);

    List<Material> findByEmailIgnoreCase(String email);

}
