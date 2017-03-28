package me.jurik99.dto.proxy_eager_lazy_fetch;

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
@Table(name = "user_details")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	// --- IF WE WANT TO CREATE "ID" IN "USER_ADDRESS" TABLE WE HAVE TO USE COLLECTION THAT SUPPORTS (INDEXES) ---
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Address> listOfAddresses = new ArrayList<>();

	public Collection<Address> getListOfAddresses()
	{
		return listOfAddresses;
	}

	public void setListOfAddresses(final Collection<Address> listOfAddresses)
	{
		this.listOfAddresses = listOfAddresses;
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
		return userName;
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
