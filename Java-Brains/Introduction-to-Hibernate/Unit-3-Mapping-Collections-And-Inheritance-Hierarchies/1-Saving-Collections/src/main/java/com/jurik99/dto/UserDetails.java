package com.jurik99.dto;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_DETAILS", schema = "saving_collections")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;

	/*
	 * In this lecture we're gonna go further and what if instead of single EMBEDDABLE object we want to have
	 * COLLECTION of that objects (to be a member variable -> field of this UserDetails class)?
	 * We want to have all possible addresses where our user lived over the years.
	 *
	 * Let's think how it works:
	 * If we had FIXED number of addresses we would have known FIXED numbers of columns like e.g. in previous
	 * lecture embedded "homeAddress" and "officeAddress".
	 * But now we don't know how many addresses we'll be having. So how do we handle that?
	 * We could think about creating different table "UserDetails_listOfAddresses" (name provided by Hibernate) and
	 * there we could reference "userId" as a foreign key.
	 *
	 * So that's what we're gonna do. Hibernate will create separate table like "UserDetails_listOfAddresses" and
	 * put there addresses in rows with "userId" as a foreign key.
	 *
	 * "Address" class is marked as EMBEDDABLE !!!
	 * That "listOfAddresses" will be persisted as SEPARATE table with all addresses added to Set !!!
	 *
	 * Hibernate: insert into USER_DETAILS_3_1_saving_collections (userName, userId) values (?, ?)
	 * Hibernate: insert into UserDetails_listOfAddresses (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME,
	 * STREET_NAME) values (?, ?, ?, ?, ?)
	 * Hibernate: insert into UserDetails_listOfAddresses (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME,
	 * STREET_NAME) values (?, ?, ?, ?, ?)
	 */
	@ElementCollection
	private Set<Address> listOfAddresses = new HashSet<>();

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

	public Set<Address> getListOfAddresses()
	{
		return listOfAddresses;
	}

	public void setListOfAddresses(final Set<Address> listOfAddresses)
	{
		this.listOfAddresses = listOfAddresses;
	}
}
