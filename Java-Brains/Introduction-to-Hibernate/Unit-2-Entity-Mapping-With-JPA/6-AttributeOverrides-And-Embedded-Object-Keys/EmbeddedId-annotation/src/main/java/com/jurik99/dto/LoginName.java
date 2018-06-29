package com.jurik99.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

/*
 * According to hint comes from IntelliJ IDEA, that class which is in "UserDetails" as ( @EmbeddedID ) must
 * implement Serializable.
 */
@Embeddable
public class LoginName implements Serializable
{
	private static final long serialVersionUID = 8322911292388827136L;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SOCIAL_SECURITY_NUMBER")
	private int socialSecurityNumber;

	@Column(name = "LOGIN_ID")
	private int loginId;

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

	public int getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(final int socialSecurityNumber)
	{
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public int getLoginId()
	{
		return loginId;
	}

	public void setLoginId(final int loginId)
	{
		this.loginId = loginId;
	}
}
