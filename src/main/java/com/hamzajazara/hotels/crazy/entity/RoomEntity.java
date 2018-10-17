package com.hamzajazara.hotels.crazy.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
@Entity(name = "room")
@Table(name = "rooms")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int id;

	@Column(name = "room_name")
	@NotEmpty
	private String name;

	@Column(name = "room_from_date")
	@NotNull
	private LocalDateTime fromDate;

	@Column(name = "room_to_date")
	@NotNull
	private LocalDateTime toDate;

	@Column(name = "room_adults_count")
	@PositiveOrZero
	private int adultsCount;

	@Column(name = "room_adults_discount")
	@PositiveOrZero
	private double discount;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private HotelEntity hotel;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<AmenityEntity> amenities;
}
