package me.jurik99.dto.many_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	private String vehicleName;

	/**
	 * In Many-To-Many there is no way to have mapping neither in the UserDetails table
	 * NOR
	 * Vehicle table.
	 * It has to be a separate table
	 */
	@ManyToMany(mappedBy = "listOfVehicles")
	private Collection<UserDetails> listOfUsers = new ArrayList<>();

	public Collection<UserDetails> getListOfUsers()
	{
		return listOfUsers;
	}

	public void setListOfUsers(final Collection<UserDetails> listOfUsers)
	{
		this.listOfUsers = listOfUsers;
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
