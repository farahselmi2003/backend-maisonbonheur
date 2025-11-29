package com.maisonbonheur.perfumebackend.repository;

import com.maisonbonheur.perfumebackend.entity.Review;
import com.maisonbonheur.perfumebackend.entity.Perfume;
import com.maisonbonheur.perfumebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByPerfume(Perfume perfume);
    List<Review> findByUser(User user);
    Optional<Review> findByUserAndPerfume(User user, Perfume perfume);
    Long countByPerfume(Perfume perfume);
    
    // Pour calculer la note moyenne
    @org.springframework.data.jpa.repository.Query("SELECT AVG(r.rating) FROM Review r WHERE r.perfume.id = :perfumeId")
    Double findAverageRatingByPerfumeId(Long perfumeId);
}