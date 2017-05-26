package me.jurik99.dto.not_found_hibernate_collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@OneToMany
	private Collection<Vehicle> listOfVehicles = new ArrayList<>();

	public Collection<Vehicle> getListOfVehicles()
	{
		return listOfVehicles;
	}

	public void setListOfVehicles(final Collection<Vehicle> listOfVehicles)
	{
		this.listOfVehicles = listOfVehicles;
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
