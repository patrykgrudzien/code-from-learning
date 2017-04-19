package com.jurik99.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
public class Profile
{
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;

	public Profile()
	{
	}

	public Profile(final long id, final String profileName, final String firstName, final String lastName)
	{
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}

	public long getId()
	{
		return id;
	}

	public void setId(final long id)
	{
		this.id = id;
	}

	public String getProfileName()
	{
		return profileName;
	}

	public void setProfileName(final String profileName)
	{
		this.profileName = profileName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(final Date created)
	{
		this.created = created;
	}
}
