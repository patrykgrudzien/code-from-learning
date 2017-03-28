package me.jurik99.dto.single_table_strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Car")
public class FourWheeler extends Vehicle
{
	private String steeringWheel;

	public String getSteeringWheel()
	{
		return steeringWheel;
	}

	public void setSteeringWheel(final String steeringWheel)
	{
		this.steeringWheel = steeringWheel;
	}
}
