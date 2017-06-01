package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_3_4_one_to_one_mapping")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	@OneToOne
	/*
	 * ----- PROFESSIONAL JAVA for WEB APPLICATIONS -----
	 * @JoinColumn - indicates which column in "this" entity's table contains the OTHER entity's PRIMARY KEY. It also
	 * replaces the @Column annotation for that property.
	 *
	 * ----- STACKOVERFLOW -----
	 * @JoinColumn - annotation indicates that this entity IS THE OWNER of the relationship (that is: the corresponding
	 * table has a column with a foreign key to the referenced table).
	 *
	 * ----- ORACLE DOCUMENTATION -----
	 * @JoinColumn - specifies a column for joining an entity association or element collection. If the @JoinColumn
	 * annotation itself is defaulted, a single join column is assumed and the default values apply.
	 */
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

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

	public Vehicle getVehicle()
	{
		return vehicle;
	}

	public void setVehicle(final Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
}