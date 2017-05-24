package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "USER_DETAILS_2_3")
public class UserDetails
{
	@Id
	private int userId;
	private String userName;
	private Date joinedDate;
	private String address;
	private String description;

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

	public Date getJoinedDate()
	{
		return joinedDate;
	}

	public void setJoinedDate(final Date joinedDate)
	{
		this.joinedDate = joinedDate;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(final String address)
	{
		this.address = address;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}
}
