package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS", schema = "one_to_many_bidirectional")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	/*
	 * Having @OneToMany for USER_DETAILS we can have @ManyToOne in VEHICLE table.
	 */
	@OneToMany
	@JoinTable(
			name = "USER_VEHICLE",
			joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
	)
	private Collection<Vehicle> vehicles = new ArrayList<>();

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

	public Collection<Vehicle> getVehicles()
	{
		return vehicles;
	}

	public void setVehicles(final Collection<Vehicle> vehicles)
	{
		this.vehicles = vehicles;
	}
}