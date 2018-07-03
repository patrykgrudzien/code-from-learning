package com.jurik99.list_of_objects_to_list_of_string;

import java.math.BigDecimal;

public class Staff
{
	private String name;
	private int age;
	private BigDecimal salary;

	public Staff(final String name, final int age, final BigDecimal salary)
	{
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(final int age)
	{
		this.age = age;
	}

	public BigDecimal getSalary()
	{
		return salary;
	}

	public void setSalary(final BigDecimal salary)
	{
		this.salary = salary;
	}
}
