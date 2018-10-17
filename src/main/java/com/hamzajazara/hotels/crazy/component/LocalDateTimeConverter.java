package com.hamzajazara.hotels.crazy.component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
	}
}