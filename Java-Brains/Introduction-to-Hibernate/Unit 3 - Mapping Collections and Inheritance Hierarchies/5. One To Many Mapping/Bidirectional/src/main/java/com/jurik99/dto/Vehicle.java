package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE", schema = "one_to_many_bidirectional")
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;

	/*
	 * Having @OneToMany for USER_DETAILS we can have @ManyToOne in VEHICLE table.
	 * We created reverse relationship. Every VEHICLE has OWNER. So no matter what vehicle you take, it should be a
	 * link pointing to the owner.
	 *
	 * We can simply take a Vehicle object in USER_DETAILS and we want to have the same functionality here - to take
	 * a User object in VEHICLE table.
	 */
	@ManyToOne
	private UserDetails user;

	public int getVehicleId()
	{
		return vehicleId;
	}

	public void setVehicleId(final int vehicleId)
	{
		this.vehicleId = vehicleId;
	}

	public String getVehicleName()
	{
		return vehicleName;
	}

	public void setVehicleName(final String vehicleName)
	{
		this.vehicleName = vehicleName;
	}

	public UserDetails getUser()
	{
		return user;
	}

	public void setUser(final UserDetails user)
	{
		this.user = user;
	}
}
