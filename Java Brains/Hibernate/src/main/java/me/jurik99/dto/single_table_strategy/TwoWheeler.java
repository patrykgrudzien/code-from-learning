package me.jurik99.dto.single_table_strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bike")
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
