package com.hamzajazara.hotels.crazy.model.response;

import java.util.ArrayList;
import java.util.List;

import com.hamzajazara.hotels.crazy.entity.HotelEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@ApiModel("Crazy Hotels Response")
@Setter
@Getter
public class CrazyHotelsResponse {

	@ApiModelProperty("Hotel Name")
	private String hotelName;

	@ApiModelProperty("Rate")
	private String rate;

	@ApiModelProperty("Price")
	private double price;

	@ApiModelProperty("Discount")
	private double discount;

	@ApiModelProperty("Amenities")
	private List<String> amenities;

	/**
	 * 
	 * @param hotelEntity
	 */
	public CrazyHotelsResponse(HotelEntity hotelEntity) {
		hotelName = hotelEntity.getName();
		rate = hotelEntity.getRate();
		price = hotelEntity.getPrice();
		amenities = new ArrayList<>();
		
		// Retrieve room info
		hotelEntity.getRooms().forEach(room -> {
			room.getAmenities().forEach(amenity -> {
				amenities.add(amenity.getName());

				// check if the room has discount
				if (room.getDiscount() > 0) {
					discount += room.getDiscount();
				}
			});
		});
	}
}
