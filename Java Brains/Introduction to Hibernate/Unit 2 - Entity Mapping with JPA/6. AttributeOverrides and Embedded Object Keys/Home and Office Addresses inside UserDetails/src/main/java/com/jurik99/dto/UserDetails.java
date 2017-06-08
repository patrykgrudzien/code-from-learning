package com.jurik99.dto;

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
@Table(name = "USER_DETAILS", schema = "home_and_office_addresses_inside_user_details")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	/*
	 * There are a few implications of having EMBEDDED objects.
	 * 1) First question - what if I would like to configure columns of my entity "UserDetals". We can add @Column
	 * annotation and configure each column I want but if we have EMBEDDED object, how do we configure all the
	 * columns of ADDRESS object? How can we (e.g.) configure CITY field of ADDRESS object to have column "CITY_NAME"?
	 *
	 * 1) First way to do that is to go to "sub" object -> ADDRESS and configure columns names by annotating them:
	 * @Column(name = " ")
	 *
	 * Other scenario is - what if we have some requirements to have HOME_ADDRESS and OFFICE_ADDRESS (we need 2
	 * address objects inside the same class)?
	 *
	 * We can solve this by OVERRIDING the default names when we're embedding !!!
	 * a) The first thing - we can e.g. override columns names for "homeAddress".
	 * b) The second thing -  if we have multiple such objects we can give unique names for each of those objects and
	 * there is no conflict. Each of those object can have OWN set of columns which are to be created for ADDRESS
	 * object. In that case we have to use:
	 * @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME"))
	 * in "name" attribute we pass (column name from Address class -> default one) and later we override that name
	 * with "column" attribute.
	 *
	 * If we want to override all properties from Address class, we have to encapsulate all ( @AttributeOverride )
	 * annotations inside another annotation called ( @AttributeOverrides ) !!!
	 */
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
		return userName + " from getter";
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
