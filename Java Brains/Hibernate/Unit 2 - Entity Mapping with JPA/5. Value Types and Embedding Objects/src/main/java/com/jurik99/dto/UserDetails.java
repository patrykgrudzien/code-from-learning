package com.jurik99.dto;

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
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

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
