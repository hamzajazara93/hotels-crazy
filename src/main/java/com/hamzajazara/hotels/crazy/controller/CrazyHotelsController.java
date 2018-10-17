package com.hamzajazara.hotels.crazy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamzajazara.hotels.crazy.entity.HotelEntity;
import com.hamzajazara.hotels.crazy.model.request.CrazyHotelsRequest;
import com.hamzajazara.hotels.crazy.model.response.CrazyHotelsResponse;
import com.hamzajazara.hotels.crazy.service.HotelService;

import io.swagger.annotations.Api;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController
@Api(tags = "Crazy Hotels")
public class CrazyHotelsController {

	@Autowired
	private HotelService hotelService;

	/**
	 * 
	 * @param hotelRequest
	 * @return
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CrazyHotelsResponse>> crazyHotels(@Valid @RequestBody CrazyHotelsRequest hotelRequest) {
		// Response
		List<CrazyHotelsResponse> response = new ArrayList<>();

		// Get Hotels Service
		List<HotelEntity> hotels = hotelService.searchHotels(hotelRequest);

		// Iterate over response and put the result on response list
		hotels.forEach(hotel -> response.add(new CrazyHotelsResponse(hotel)));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}