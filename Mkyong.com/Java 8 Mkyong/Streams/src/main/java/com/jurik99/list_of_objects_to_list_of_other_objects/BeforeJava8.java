package com.jurik99.list_of_objects_to_list_of_other_objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeJava8
{
	public static void main(final String[] args)
	{
		final List<Staff> staff = Arrays.asList(
				new Staff("mkyong", 30, new BigDecimal("10000")),
				new Staff("jack", 27, new BigDecimal("2000")),
				new Staff("lawrence", 33, new BigDecimal(3000))
		);

		final List<StaffPublic> result = convertToStaffPublic(staff);
		System.out.println(result);
	}

	private static List<StaffPublic> convertToStaffPublic(final List<Staff> staff)
	{
		final List<StaffPublic> result = new ArrayList<>();

		for (final Staff temp : staff)
		{
			final StaffPublic obj = new StaffPublic();
			obj.setName(temp.getName());
			obj.setAge(temp.getAge());
			if ("mkyong".equals(temp.getName()))
			{
				obj.setExtra("This field is for mkyong only!");
			}
			result.add(obj);
		}
		return result;
	}
}
