package com.jurik99.dto;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jurik99.schemas.SchemaNames;

@Entity
@Table(name = "VEHICLE", schema = SchemaNames.Unit3.NOT_FOUND_ANNOTATION_SCHEMA)
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;

	/*
	 * Let's assume that this VEHICLE does NOT HAVE an owner (this vehicle is not rented yet).
	 * So, what would happen in case of that association here if we have getter and setter for user?
	 * When we would want to retrieve USER from VEHICLE, Hibernate will throw an EXCEPTION because there is no user
	 * associated to vehicle.
	 *
	 * There is a way to suppress that exception and Hibernate won't come up with an error.
	 * To prevent throwing such exceptions, we can use:
	 * @NotFound - annotation (if the user is not found, then what to do...)
	 * This annotation comes from "org.hibernate.annotations" so IT IS NOT A JPA STANDARD !!! This is a feature that
	 * Hibernate provides for us.
	 *
	 * We can specify an ACTION in @NotFound properties:
	 * @NotFound(action = NotFoundAction.IGNORE || NotFoundAction.EXCEPTION)
	 */
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
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
