package com.jurik99;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable
{
	private String name;
	private BigDecimal salary;
	private Date hireDay;

	public Employee(final String name, final double salary)
	{
		this.name = name;
		this.salary = BigDecimal.valueOf(salary);
		this.hireDay = new Date();
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		/*
		 * Shallow version of clone() method - just added "public" modifier:
		 * return (Employee) super.clone();
		 */

		// --- Deep cloning ---
		final Employee clonedObject = (Employee) super.clone();

		// --- Copying fields which are mutable ---
		clonedObject.hireDay = (Date) hireDay.clone();

		return clonedObject;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public BigDecimal getSalary()
	{
		return salary;
	}

	public void setSalary(final double salary)
	{
		this.salary = BigDecimal.valueOf(salary);
	}

	public Date getHireDay()
	{
		return hireDay;
	}

	public void setHireDay(final int year, final int month, final int day)
	{
		final Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}

	@Override
	public String toString()
	{
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", hireDay=" + hireDay + '}';
	}
}
