package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.jurik99.schemas.SchemaNames;

@Entity
@Table(name = "VEHICLE", schema = SchemaNames.Unit3.TABLE_PER_CLASS_STRATEGY_SCHEMA)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle
{
	/*
	 * We're gonna have separate table per EACH entity class in "table per class" strategy.
	 * Vehicle will be a separate table.
	 * TwoWheeler will be a separate table.
	 * FourWheeler will be a separate table.
	 */
	@Id
	@GeneratedValue     // that @GeneratedValue is also inheritanted in child classes !!!
	private int vehicleId;
	private String vehicleName;

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
