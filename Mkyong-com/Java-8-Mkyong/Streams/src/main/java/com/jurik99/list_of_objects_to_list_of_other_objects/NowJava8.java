package com.jurik99.list_of_objects_to_list_of_other_objects;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NowJava8
{
	public static void main(final String[] args)
	{
		final List<Staff> staff = Arrays.asList(
				new Staff("mkyong", 30, new BigDecimal("10000")),
				new Staff("jack", 27, new BigDecimal("2000")),
				new Staff("lawrence", 33, new BigDecimal(3000))
		);

		// --- CONVERT INSIDE THE "map()" METHOD DIRECTLY ---
		final List<StaffPublic> result = staff.stream().map(person -> {
			final StaffPublic obj = new StaffPublic();
			obj.setName(person.getName());
			obj.setAge(person.getAge());
			if ("mkyong".equals(person.getName()))
			{
				obj.setExtra("This field is for mkyong only!");
			}
			return obj;
		}).collect(Collectors.toList());

		System.out.println(result);
	}
}
