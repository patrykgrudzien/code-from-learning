package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS", schema = "many_to_many")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	/*
	 * There is only ONE WAY to represent "Many To Many" mapping. It has to have the MAPPING TABLE.
	 * Assume scenario:
	 * We have a RENTAL vehicle. User can rent MULTIPLE vehicles and VEHICLE can be rented by MULTIPLE users.

	 * In that case user will have list of vehicles and vehicle will have list of users. We cannot have mapping on
	 * either "UserDetails" or "Vehicle" side.
	 * IT HAS TO BE SEPARATE TABLE !!!
	 *
	 * We'll implement BIDIRECTIONAL relationship.
	 * -----------------------------------------------------------------------------------------------------------------
	 * Hibernate for now DOES NOT know that it needs ONLY ONE MAPPING. It's doing 2 mappings.
	 * We need to tell Hibernate to map ONLY to ONE TABLE.
	 *
	 * To do only ONE mapping, we have to pick one of THAT classes e.g. USER_DETAILS and tell Hibernate that this
	 * class will have a mapping. "UserId" forms the first column and "vehicleId" forms the second column.
	 */
	@ManyToMany
	@JoinTable(
			name = "JOINED_TABLE",
			joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
	)
	private Collection<Vehicle> vehiclesList = new ArrayList<>();

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

	public Collection<Vehicle> getVehiclesList()
	{
		return vehiclesList;
	}

	public void setVehiclesList(final Collection<Vehicle> vehiclesList)
	{
		this.vehiclesList = vehiclesList;
	}
}