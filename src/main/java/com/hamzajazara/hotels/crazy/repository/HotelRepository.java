package com.hamzajazara.hotels.crazy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hamzajazara.hotels.crazy.entity.HotelEntity;
import com.hamzajazara.hotels.crazy.model.request.CrazyHotelsRequest;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

	/**
	 * 
	 * @param hotelsRequest
	 * @return
	 */
	@Query("select h from hotel h join h.rooms r where h.city like :#{#hotelsRequest.city} And r.adultsCount = :#{#hotelsRequest.adultsCount} And r.fromDate >= :#{#hotelsRequest.fromDate} And r.toDate <= :#{#hotelsRequest.toDate}")
	List<HotelEntity> getCrazyhotels(@Param("hotelsRequest") CrazyHotelsRequest hotelsRequest);
}
