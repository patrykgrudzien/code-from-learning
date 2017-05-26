package com.jurik99.dto;

import javax.persistence.Embeddable;

/*
 * In order to mark this class as VALUE TYPE and to tell Hibernate NOT to create separate table, we have to use
 * another annotation:
 * @Embeddable
 */
@Embeddable
public class Address
{
	private String street;
	private String city;
	private String state;
	private String pincode;

	public String getStreet()
	{
		return street;
	}

	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(final String pincode)
	{
		this.pincode = pincode;
	}
}
