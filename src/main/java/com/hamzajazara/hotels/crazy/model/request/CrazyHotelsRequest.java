package com.hamzajazara.hotels.crazy.model.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@ApiModel("Crazy Hotels Request")
@Setter
@Getter
public class CrazyHotelsRequest {

	@ApiModelProperty("City")
	@NotEmpty(message = "City can't be empty")
	private String city;

	@ApiModelProperty("From Date")
	@NotNull(message = "From Date can't be null")
	private LocalDateTime fromDate;

	@ApiModelProperty("To Date")
	@NotNull(message = "To Date can't be null")
	private LocalDateTime toDate;

	@ApiModelProperty("Adults Count")
	@PositiveOrZero
	private int adultsCount;
}
