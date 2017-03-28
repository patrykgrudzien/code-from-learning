package me.jurik99.dto.mappedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	private String vehicleName;

	/**
	 * User table cannot have column for the Vehicle_ID because ONE "user" can have multiple "vehicles"
	 * but the "vehicle" table can have the "user" column because
	 * any "vehicle" will have only one user
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDetails user;

	public UserDetails getUser()
	{
		return user;
	}

	public void setUser(final UserDetails user)
	{
		this.user = user;
	}

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
}
