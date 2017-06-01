package com.jurik99.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS_3_3_proxy_objects_eager_lazy_fetch_types")
public class UserDetails
{
	/*
	 * We're gonna look at what PROXY OBJECTS are and how Hibernate provides them for us.
	 * More comments in "HibernateTest" class.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;

	@ElementCollection(fetch = FetchType.EAGER)
	/*
	 * @JoinTable is used in the mapping of associations. It's specified on the OWNING SIDE of an association.
	 * @JoinTable = połącz ze sobą 2 tabele (główną oznaczoną @Entity i "poboczną" utworzoną przez
	 * @ElementCollection) kluczem podstawowym i obcym oraz nazwij kolumny przy pomocy atrybutu (name = " ").
	 */
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Address> listOfAddresses = new ArrayList<>();

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

	public Collection<Address> getListOfAddresses()
	{
		return listOfAddresses;
	}

	public void setListOfAddresses(final Collection<Address> listOfAddresses)
	{
		this.listOfAddresses = listOfAddresses;
	}
}
