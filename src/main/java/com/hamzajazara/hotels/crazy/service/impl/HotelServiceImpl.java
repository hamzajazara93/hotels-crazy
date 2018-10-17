package com.hamzajazara.hotels.crazy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamzajazara.hotels.crazy.entity.HotelEntity;
import com.hamzajazara.hotels.crazy.model.request.CrazyHotelsRequest;
import com.hamzajazara.hotels.crazy.repository.HotelRepository;
import com.hamzajazara.hotels.crazy.service.HotelService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	/*
	 * @see
	 * com.hamzajazara.hotels.crazy.service.HotelService#getHotels(com.hamzajazara.
	 * hotels.crazy.model.request.CrazyHotelsRequest)
	 */
	@Override
	public List<HotelEntity> searchHotels(CrazyHotelsRequest hotelsRequest) {
		return hotelRepository.getCrazyhotels(hotelsRequest);
	}
}
