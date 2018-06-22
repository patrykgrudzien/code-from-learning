package com.jurik99.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
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
