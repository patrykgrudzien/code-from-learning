package me.jurik99.dto.many_to_one;

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

	@ManyToOne
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
