package me.jurik99.dto.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
	                     @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
	                     @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
	                     @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE"))})
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(final int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}

	public Address getOfficeAddress()
	{
		return officeAddress;
	}

	public void setOfficeAddress(final Address officeAddress)
	{
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(final Address address)
	{
		this.homeAddress = address;
	}
}
