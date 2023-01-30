package com.example.Restaurants.Dao;

import com.example.Restaurants.Entity.pdf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface pdfDao extends JpaRepository<pdf, String> {
    @Query(value = "select * FROM files WHERE rest_id = :id", nativeQuery = true)
    Optional<pdf> findByRestId(
            @Param("id") String id
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM files WHERE rest_id= :id", nativeQuery = true)
    void deleteByRestId(
            @Param("id") int id
    );
}
