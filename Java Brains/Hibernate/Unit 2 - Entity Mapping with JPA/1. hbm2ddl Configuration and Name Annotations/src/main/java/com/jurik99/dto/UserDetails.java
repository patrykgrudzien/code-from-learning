package com.jurik99.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * If we want to have "User" table in database we'll face problem.
 * Database will NOT allow to create such table because "user" is RESTRICTED KEYWORD in most databases !!!
 * Something may be restricted from database point of view but not from Java point of view.
 *
 * To deal with that problem we can use:
 * @Entity (name = " ")
 * As a result we'll create table called "USER_DETAILS" instead of default name taken from
 * java class name  ->  "userdetails".
 */
@Entity(name = "USER_DETAILS")
public class UserDetails
{
	/*
	 * We can have also OWN column name similar to table name by annotating FIELD.
	 */
	@Id
	@Column(name = "USER_ID")
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

	/*
	 * Alternative way of changing column name is to ANNOTATE GETTERS INSTEAD OF FIELDS ITSEFL.
	 */
	@Column(name = "USER_NAME")
	public String getUserName()
	{
		return userName + " from getter";
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
