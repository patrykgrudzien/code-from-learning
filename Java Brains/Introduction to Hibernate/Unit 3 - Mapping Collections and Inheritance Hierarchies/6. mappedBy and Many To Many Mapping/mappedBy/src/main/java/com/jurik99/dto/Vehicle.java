package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE", schema = "mapped_by")
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;

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
	 * ----------------------------------------------------------------------------------------------------------------
	 * We need to say that VEHICLE must have a MAPPING of the relationship.
	 * "mappedBy" says where we want a mapping to happen.
	 * ----------------------------------------------------------------------------------------------------------------
	 * HERE in VEHICLE table we have to specify what is the JOIN COLUMN. We're naming the join column that we're
	 * creating inside the VEHICLE table itself.
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID")
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
