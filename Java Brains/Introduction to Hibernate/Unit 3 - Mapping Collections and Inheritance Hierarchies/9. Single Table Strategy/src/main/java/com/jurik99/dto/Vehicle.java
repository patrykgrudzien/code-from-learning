package com.jurik99.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.jurik99.schemas.SchemaNames;

@Entity
@Table(name = "VEHICLE", schema = SchemaNames.Unit3.SINGLE_TABLE_STRATEGY_SCHEMA)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "VEHICLE_TYPE",
		discriminatorType = DiscriminatorType.STRING
)
public class Vehicle
{
	/*
	 * In "single table" strategy Hibernate creates one table and inserts one EXTRA column there called DTYPE.
	 * DTYPE tells what class it is (class name).
	 * First record is BASE class VEHICLE and has only "vehicle_name" and "vehicle_id". Values for "steeringHandle"
	 * and "steeringWheel" are blank.
	 *
	 * This "DTYPE" is called as DISCRIMINATOR.
	 * In order to make queries easier or just to identify what type of object we're saving (we're having in database),
	 * we have separated column which tells what class it is cause we would have bike with not "steeringHandle" set
	 * and that row in database would look like the same as VEHICLE and how could we distinguish them if all records
	 * have all columns? This is a default implementation of Hibernate.
	 *
	 * The way to configure strategy is by going to parent class and explicitly specify strategy in:
	 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE) annotation (it's not mandatory).
	 *
	 * There is another option to do here. We can configure DISCRIMINATOR how it would be generated:
	 * @DiscriminatorColumn(
	 *	name = "VEHICLE_TYPE",
	 *	discriminatorType = DiscriminatorType.STRING
	 *	)
	 * We can have different type of Discriminator e.g. CHAR, INTEGER and class. If we run this configuration we
	 * change DTYPE column to VEHICLE_TYPE. But there is additional thing we can do. We can change a name of Entity
	 * in VEHICLE_TYPE column (by default it is a class name) by going to child classes of Vehicle and mark them with
	 * @DiscriminatorValue("...")
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
