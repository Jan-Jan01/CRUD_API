package com.example.demo.hunter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HunterRepository extends JpaRepository<Hunter, Long> {
    @Query("Select s FROM Hunter s Where s.email = ?1")
    Optional<Hunter> findHunterByEmail(String email);
}
