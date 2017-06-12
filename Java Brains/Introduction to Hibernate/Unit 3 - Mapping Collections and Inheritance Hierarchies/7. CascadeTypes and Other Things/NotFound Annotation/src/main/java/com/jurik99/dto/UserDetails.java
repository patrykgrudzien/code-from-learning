package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

import com.jurik99.schemas.SchemaNames;

@Entity
@Table(name = "USER_DETAILS", schema = SchemaNames.Unit3.NOT_FOUND_ANNOTATION_SCHEMA)
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	@OneToMany
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