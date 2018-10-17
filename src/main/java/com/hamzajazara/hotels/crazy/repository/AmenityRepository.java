package com.hamzajazara.hotels.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamzajazara.hotels.crazy.entity.AmenityEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface AmenityRepository extends JpaRepository<AmenityEntity, Integer> {
}
