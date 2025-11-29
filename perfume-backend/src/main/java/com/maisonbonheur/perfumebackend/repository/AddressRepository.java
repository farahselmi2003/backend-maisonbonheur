package com.maisonbonheur.perfumebackend.repository;

import com.maisonbonheur.perfumebackend.entity.Address;
import com.maisonbonheur.perfumebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUser(User user);
    Optional<Address> findByUserAndIsDefaultTrue(User user);
    List<Address> findByUserId(Long userId);
}