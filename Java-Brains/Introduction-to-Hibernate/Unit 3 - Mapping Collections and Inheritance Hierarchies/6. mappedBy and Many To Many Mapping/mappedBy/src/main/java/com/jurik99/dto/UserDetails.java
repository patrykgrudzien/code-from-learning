package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS", schema = "mapped_by")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	/*
	 * Annotating previously collection of vehicles by:
	 * @OneToMany and
	 * @JoinTable(name = "", joinColumns = @JoinColumn(name = ""), inverseJoinColumns = @JoinColumn(name = ""))
	 * Hibernate by default, created separated MAPPING TABLE and he inserted ID's of both: User and Vahicle entities.
	 * He had also separated table for User and Vehicle itself.
	 *
	 * There is another way to represent "OneToMany" and "ManyToOne" relationship. The object on the MANY SIDE of the
	 * relationship has a reference to the other object.
	 * Now the USER table cannot have a column for the VEHICLE_ID because ONE user can have MULTIPLE VEHICLES.
	 * But the VEHICLE table can have USER_ID column because ANY vehicle will have ONLY ONE USER. So we can have
	 * USER_ID column in VEHICLE table without creating separated mapping table.
	 *
	 * We need to say that VEHICLE must have a MAPPING of the relationship.
	 * "mappedBy" says where we want a mapping to happen.
	 */
	@OneToMany(mappedBy = "user")
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