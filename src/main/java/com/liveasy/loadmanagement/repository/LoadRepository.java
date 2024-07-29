package com.liveasy.loadmanagement.repository;

import com.liveasy.loadmanagement.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
    List<Load> findByShipperId(UUID shipperId);
}
