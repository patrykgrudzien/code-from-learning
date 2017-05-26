package me.jurik99.dto.transient_persistent_detached;

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
