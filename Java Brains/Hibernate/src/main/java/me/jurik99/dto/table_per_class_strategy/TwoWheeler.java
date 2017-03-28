package me.jurik99.dto.table_per_class_strategy;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle
{
	private String steeringHandle;

	public String getSteeringHandle()
	{
		return steeringHandle;
	}

	public void setSteeringHandle(final String steeringHandle)
	{
		this.steeringHandle = steeringHandle;
	}
}
