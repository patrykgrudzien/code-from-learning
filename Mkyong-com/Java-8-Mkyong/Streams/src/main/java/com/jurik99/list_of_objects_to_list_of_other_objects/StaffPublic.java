package com.jurik99.list_of_objects_to_list_of_other_objects;

public class StaffPublic
{
	private String name;
	private int age;
	private String extra;

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

	public String getExtra()
	{
		return extra;
	}

	public void setExtra(final String extra)
	{
		this.extra = extra;
	}

	@Override
	public String toString()
	{
		return "StaffPublic{" + "name='" + name + '\'' + ", age=" + age + ", extra='" + extra + '\'' + '}';
	}
}
