package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails
{
	@Id
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
		return userName;
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
