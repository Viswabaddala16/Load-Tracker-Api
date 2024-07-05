package com.loadmanagement.postgresql.repository;

import com.loadmanagement.postgresql.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
    Optional<Load> findByIdAndShipperId(Long id, UUID shipperId);
    List<Load> findByShipperId(UUID shipperId);
}
