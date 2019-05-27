package info.grudzien.patryk.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone
{
	@Id
	@GeneratedValue
	private long id;

	private String type;
	private String numer;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getNumer()
	{
		return numer;
	}

	public void setNumer(String numer)
	{
		this.numer = numer;
	}

}
