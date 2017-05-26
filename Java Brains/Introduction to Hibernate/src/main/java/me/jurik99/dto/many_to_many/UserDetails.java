package me.jurik99.dto.many_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	/**
	 * In Many-To-Many there is no way to have mapping neither in the UserDetails table
	 * NOR
	 * Vehicle table.
	 * It has to be a separate table
	 */
	@ManyToMany
	@JoinTable(name = "MANY_TO_MANY", joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private Collection<Vehicle> listOfVehicles = new ArrayList<>();

	public Collection<Vehicle> getListOfVehicles()
	{
		return listOfVehicles;
	}

	public void setListOfVehicles(final Collection<Vehicle> listOfVehicles)
	{
		this.listOfVehicles = listOfVehicles;
	}

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
		return userName;
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
