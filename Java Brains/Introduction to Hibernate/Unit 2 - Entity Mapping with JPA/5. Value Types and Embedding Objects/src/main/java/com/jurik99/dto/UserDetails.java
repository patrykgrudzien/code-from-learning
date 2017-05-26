package com.jurik99.dto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_2_5")
public class UserDetails
{
	/*
	 * So far, examples we have taken, allow us to have SINGLE COLUMN FOR EACH MEMBER VARIABLE (FIELD) because of the
	 * data type (primitive).
	 *
	 * Question is - what if one of member variables (field) would be AN OBJECT instead of simple data type?
	 * How would we save it in table?
	 *
	 * 1) First Scenario that we wanna take:
	 * In "UserDetails" we'll have ADDRESS as an OBJECT, NOT String like we had so far.
	 * The user class has an ADDRESS object and the ADDRESS object has some member variables (fields). We're gonna
	 * treat member variables of ADDRESS object in the same way we would treat the member variables of USER class
	 * itself.
	 * ONE APPROACH - Separate Columns (it works if object inside USER class (our "ADDRESS") is a VALUE OBJECT.
	 *
	 * When we deal with Hibernate we have 2 kinds of objects:
	 * a) ENTITY object (user is an Entity, it's saved in separate table in the database, it's independent and it
	 * contains data that provides meaning about itself).
	 * b) VALUE object (it's object that has data and it has to be saved in database but ID DOES NOT HAVE MEANING
	 * ABOUT ITSELF, IT PROVIDES MEANING TO SOME OTHER OBEJECT e.g. "address" object provides meaning to USER).
	 * Address itself has fields like "street, city, state, pincode" but when we want to establish WHAT address are
	 * we talking about - we simply don't know. That's why it HAS NO MEANING ABOUT ITSELF. It's an address of USER
	 * class.
	 *
	 * VALUE object has A VALUE FOR AN ENTITY !!! It does NOT have meaning of its OWN !!!
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	@Embedded
	private Address address;

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(final Address address)
	{
		this.address = address;
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
