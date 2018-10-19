package com.booksandsubjectsmvcrestful;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class DateConvertor implements AttributeConverter<LocalDate, Date> 
{

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) 
	{
		if(localDate==null)
		{
			return null;
		}
		else
		{
			return Date.valueOf(localDate);
		}
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate)
	{
		if(sqlDate!=null)
		{
			return sqlDate.toLocalDate();
		}
		else
		{
			return null;
		}
		
	}



}
