package com.booksandsubjectsmvchibernatedataboot;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class DateConvertor implements AttributeConverter<LocalDate, Date> 
{

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) 
	{
		System.out.println("converterrrrr1");
		if(localDate==null)
		{
			return null;
		}
		else
		{
			System.out.println("Date.valueOf(localDate)"+Date.valueOf(localDate));
			return Date.valueOf(localDate);
		}
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate)
	{
		System.out.println("converterrrrr2");
		if(sqlDate!=null)
		{
			System.out.println("sqlDate.toLocalDate()"+sqlDate.toLocalDate());
			return sqlDate.toLocalDate();
		}
		else
		{
			return null;
		}
		
	}



}
