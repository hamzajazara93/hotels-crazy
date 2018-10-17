package com.hamzajazara.hotels.crazy.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hamzajazara.hotels.crazy.entity.HotelEntity;
import com.hamzajazara.hotels.crazy.entity.RoomEntity;
import com.hamzajazara.hotels.crazy.model.request.CrazyHotelsRequest;
import com.hamzajazara.hotels.crazy.repository.HotelRepository;

/**
 * 
 * @author haljazara
 *
 */
@RunWith(SpringRunner.class)
public class HotelServiceImplTest {

	@InjectMocks
	HotelServiceImpl hotelServiceImpl;

	@MockBean
	HotelRepository hotelRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSearchHotels() {
		// Assert
		CrazyHotelsRequest hotelsRequest = new CrazyHotelsRequest();
		hotelsRequest.setAdultsCount(5);
		hotelsRequest.setCity("Faro");
		hotelsRequest.setFromDate(LocalDateTime.now());
		hotelsRequest.setToDate(LocalDateTime.now().plusDays(10));

		// Arrange
		List<RoomEntity> rooms = Arrays.asList(RoomEntity.builder().adultsCount(5).fromDate(LocalDateTime.now())
				.toDate(LocalDateTime.now().plusDays(10)).build());
		List<HotelEntity> hotels = Arrays.asList(HotelEntity.builder().city("Faro").rooms(rooms).build());
		when(hotelRepository.getCrazyhotels(hotelsRequest)).thenReturn(hotels);

		// Act
		assertEquals(hotels, hotelServiceImpl.searchHotels(hotelsRequest));
	}
}
