package com.hamzajazara.hotels.crazy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hamzajazara.hotels.crazy.entity.HotelEntity;
import com.hamzajazara.hotels.crazy.model.request.CrazyHotelsRequest;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface HotelService {

	/**
	 * 
	 * @param hotelRequest
	 * @return
	 */
	List<HotelEntity> searchHotels(CrazyHotelsRequest hotelRequest);
}
