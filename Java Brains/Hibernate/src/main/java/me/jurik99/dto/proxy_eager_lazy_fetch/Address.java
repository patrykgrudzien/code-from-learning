package me.jurik99.dto.proxy_eager_lazy_fetch;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address
{
	@Column(name = "STREET_NAME")
	private String street;

	@Column(name = "CITY_NAME")
	private String city;

	@Column(name = "STATE_NAME")
	private String state;

	@Column(name = "PIN_CODE")
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
