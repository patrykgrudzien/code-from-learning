package com.jurik99.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS", schema = "embedded_id_annotation")
public class UserDetails
{
	/*
	 * There is one special case where "userId", the PRIMARY KEY of this model object can be an EMBEDDED object.
	 * E.g. we have an object that has: "firstName", "lastName", "socialSecurityNumber", "loginId" etc. and
	 * combination of all those IS A PRIMARY KEY.
	 * In that case we can have e.g. "loginName" object and that itself will be a primary key. We can use @Embedded
	 * annotation but it WOULD NOT work with @Id (we also have to remove @GeneratedValue) !!!
	 *
	 * LoginName would have COMBINATION of fields that forms a PRIMARY KEY. Instead of @Id and @Embedded
	 * we have to use: @EmbeddedId.
	 *
	 * LoginName of course MUST HAVE @Embeddable annotation !!!
	 */
	@EmbeddedId
	private LoginName loginName;    // previously it was -> "userId"
	private String userName;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME"))
	})
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	public Address getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(final Address homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress()
	{
		return officeAddress;
	}

	public void setOfficeAddress(final Address address)
	{
		this.officeAddress = address;
	}

	public LoginName getLoginName()
	{
		return loginName;
	}

	public void setLoginName(final LoginName loginName)
	{
		this.loginName = loginName;
	}

	public String getUserName()
	{
		return userName + " from getter";
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
