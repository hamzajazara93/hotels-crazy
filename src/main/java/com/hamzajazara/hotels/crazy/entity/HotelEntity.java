package com.hamzajazara.hotels.crazy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "hotel")
@Table(name = "hotels")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HotelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotels_id")
	private int id;

	@Column(name = "hotel_name")
	@NotEmpty
	private String name;

	@Column(name = "hotel_city")
	@NotEmpty
	private String city;

	@Column(name = "hotel_price")
	@PositiveOrZero
	private double price;

	@Column(name = "hotel_rate")
	@NotEmpty
	private String rate;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<RoomEntity> rooms;
}
