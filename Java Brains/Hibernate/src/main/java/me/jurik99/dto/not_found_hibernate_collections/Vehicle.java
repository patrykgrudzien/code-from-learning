package me.jurik99.dto.not_found_hibernate_collections;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	private String vehicleName;

	/**
	 * If the "User" is not found we can specify an action that handle such situation
	 * when there in no relationship available
	 */
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
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
