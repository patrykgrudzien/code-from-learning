package info.grudzien.patryk.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address
{
	@Id
	@GeneratedValue
	private long id;
	
	private String locality;
	private String zipCode;
	private String streetName;
	private int streetNumber;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getLocality()
	{
		return locality;
	}
	public void setLocality(String locality)
	{
		this.locality = locality;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public String getStreetName()
	{
		return streetName;
	}
	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}
	public int getStreetNumber()
	{
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber)
	{
		this.streetNumber = streetNumber;
	}
	
}
