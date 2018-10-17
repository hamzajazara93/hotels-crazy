package com.hamzajazara.hotels.crazy.component;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.hamzajazara.hotels.crazy.entity.AmenityEntity;
import com.hamzajazara.hotels.crazy.entity.HotelEntity;
import com.hamzajazara.hotels.crazy.entity.RoomEntity;
import com.hamzajazara.hotels.crazy.repository.AmenityRepository;
import com.hamzajazara.hotels.crazy.repository.HotelRepository;
import com.hamzajazara.hotels.crazy.repository.RoomRepository;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private AmenityRepository amenityRepository;

	/**
	 * Data Seed
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Hotels
		HotelEntity hotel1 = hotelRepository.saveAndFlush(
				HotelEntity.builder().id(1).name("Crazy Hotel 1").price(100).rate("***").city("Faro").build());

		HotelEntity hotel2 = hotelRepository.saveAndFlush(
				HotelEntity.builder().id(2).name("Crazy Hotel 2").price(150).rate("*****").city("Kribi").build());

		HotelEntity hotel3 = hotelRepository.saveAndFlush(
				HotelEntity.builder().id(3).name("Crazy Hotel 3").price(40).rate("*").city("Ambler").build());

		HotelEntity hotel4 = hotelRepository.saveAndFlush(
				HotelEntity.builder().id(4).name("Crazy Hotel 4").price(110).rate("****").city("Exeter").build());

		// Rooms
		RoomEntity room1 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(1).name("Crazy Room 1").fromDate(LocalDateTime.of(2018, 10, 1, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 10, 0, 0)).adultsCount(5).hotel(hotel1).build());

		RoomEntity room2 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(2).name("Crazy Room 2").fromDate(LocalDateTime.of(2018, 10, 8, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 26, 0, 0)).adultsCount(5).hotel(hotel1).build());

		RoomEntity room3 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(3).name("Crazy Room 3").fromDate(LocalDateTime.of(2018, 10, 12, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 16, 0, 0)).adultsCount(5).hotel(hotel2).build());

		RoomEntity room4 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(4).name("Crazy Room 4").fromDate(LocalDateTime.of(2018, 10, 18, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 20, 0, 0)).adultsCount(3).hotel(hotel3).build());

		RoomEntity room5 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(5).name("Crazy Room 5").fromDate(LocalDateTime.of(2018, 10, 22, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 25, 0, 0)).adultsCount(7).hotel(hotel4).build());

		RoomEntity room6 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(6).name("Crazy Room 6").fromDate(LocalDateTime.of(2018, 10, 18, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 26, 0, 0)).adultsCount(7).hotel(hotel4).build());

		RoomEntity room7 = roomRepository.saveAndFlush(
				RoomEntity.builder().id(7).name("Crazy Room 7").fromDate(LocalDateTime.of(2018, 10, 22, 0, 0))
						.toDate(LocalDateTime.of(2018, 10, 30, 0, 0)).adultsCount(7).hotel(hotel4).build());

		// Amenities
		amenityRepository.saveAndFlush(AmenityEntity.builder().id(1).name("Crazy - Free Parking").room(room1).build());
		amenityRepository
				.saveAndFlush(AmenityEntity.builder().id(2).name("Crazy - Luxury Bedding").room(room2).build());
		amenityRepository.saveAndFlush(AmenityEntity.builder().id(3).name("Crazy - Swimming Pool").room(room3).build());
	}
}
