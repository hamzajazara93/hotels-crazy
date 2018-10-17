package com.hamzajazara.hotels.crazy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Entity(name = "amenity")
@Table(name = "amenities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AmenityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "amenities_id")
	private int id;

	@Column(name = "amenities_name")
	@NotEmpty
	private String name;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;
}
