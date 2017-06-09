package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

import com.jurik99.schemas.SchemaNames;

@Entity
@Table(name = "VEHICLE", schema = SchemaNames.Unit3.CASCADE_SCHEMA)
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;

	// --- We want to have mapping on USER_DETAILS table (to have there VEHICLE_ID column) ---
	@ManyToMany(mappedBy = "vehiclesList")
	private Collection<UserDetails> usersList = new ArrayList<>();

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

	public Collection<UserDetails> getUsersList()
	{
		return usersList;
	}

	public void setUsersList(final Collection<UserDetails> usersList)
	{
		this.usersList = usersList;
	}
}
