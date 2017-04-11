package com.jurik99.rest;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import static com.jurik99.rest.DateConstants.TOMORROW;
import static com.jurik99.rest.DateConstants.YESTERDAY;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider
{
	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType,
	                                          final Annotation[] annotations)
	{
		if (rawType.getName().equals(MyDate.class.getName()))
		{
			return new ParamConverter<T>()
			{
				@Override
				public T fromString(final String param)
				{
					final Calendar currentDate = Calendar.getInstance();
					if (param.equals(TOMORROW))
					{
						currentDate.add(Calendar.DATE, 1);
					}
					else if (param.equals(YESTERDAY))
					{
						currentDate.add(Calendar.DATE, -1);
					}
					final MyDate myDate = new MyDate();
					myDate.setDate(currentDate.get(Calendar.DATE));
					myDate.setMonth(currentDate.get(Calendar.MONTH) + 1);
					myDate.setYear(currentDate.get(Calendar.YEAR));

					return rawType.cast(myDate);
				}

				@Override
				public String toString(final T myDate)
				{
					return myDate.toString();
				}
			};
		}
		return null;
	}
}
