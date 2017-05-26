package me.jurik99.dto.inheritance;

import javax.persistence.Entity;

@Entity
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
