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
@Table(name = "USER_DETAILS", schema = "one_to_many_unidirectional")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	/*
	 * You use "joinColumns" to specify one or more @JoinColumn(s) that indicate
	 * which column or columns "THIS" (the owning) entity's primary key maps to.
	 * Likewise, you use "inverseJoinColumns" to specify one or more @JoinColumn(s) that indicate which column or
	 * columns the other (owned) entity's primary key maps to.
	 */
	@OneToMany
	/*
	 * With default annotation and no configuration, Hibernate created 3 tables:
	 * 1) USER_DETAILS - (userId, userName)
	 * 2) VEHICLE - (vehicleId, vehicleName)
	 * 3) USER_DETAILS_VEHICLE - (USER_DETAILS_userId, vehicles_vehicleId)
	 *
	 * vehicles_vehicleId (vehicles because of the name of field:
	 * private Collection<Vehicle> vehicles = new ArrayList<>();
	 *
	 * We can configure @JoinColumn and @JoinTable.
	 * @JoinTable - create JOIN TABLE, set columns from USER_DETAILS (joinColumms = ) and columns from VEHICLE
	 * (inverseJoinColumns = )
	 *
	 * (joinColumns = ) - allows us to configure the name of the columns from the USER_DETAILS table.
	 */
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