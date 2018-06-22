package com.jurik99.dto;

import javax.persistence.CascadeType;
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
@Table(name = "USER_DETAILS", schema = SchemaNames.Unit3.CASCADE_SCHEMA)
public class UserDetails
{
	/*
	 * CASCADE - ia applicable to all relationships:
	 * OneToOne, OneToMany, ManyToOne, ManyToMany
	 *
	 * What CASCADE means?
	 * Let's say we have e.g. USER which has 10 VEHICLES.
	 * We have to assign each vehicle with that user and when we want to save that user in database we also have to
	 * save ALL VEHICLES. What if we would have 100 vehicles assigned to ONE USER ?!
	 *
	 * It's not only for saving. When we're deleting the USER we have to delete all vehicles associated with deleted
	 * user. So, whatever operation we do for a user, we HAVE TO DO THE SAME OPERATIONS FOR EACH VEHICLE ASSOCIATED
	 * WITH THAT USER.
	 *
	 * There is a way to avoid this and we can use something like "Cascade".
	 * In this example, we have only unidirectional relationship between UserDetails and Vehicle. Vehicle has no
	 * reference to UserDetails object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	/*
	 * Here we're using:
	 * @OneToMany(cascade = CascadeType.PERSIST) attribute to save all vehicles associated with user object.
	 * Another thing we have to remember is METHOD responsible for saving user.
	 * Instead of using "session.save(...)" we have to use "session.persist(...)" !!!
	 */
	@OneToMany(cascade = CascadeType.PERSIST)
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