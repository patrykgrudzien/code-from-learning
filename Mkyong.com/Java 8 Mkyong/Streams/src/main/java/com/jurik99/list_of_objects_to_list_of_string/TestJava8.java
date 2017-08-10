package com.jurik99.list_of_objects_to_list_of_string;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8
{
	public static void main(final String[] args)
	{
		final List<Staff> staff = Arrays.asList(
				new Staff("mkyong", 30, new BigDecimal("10000")),
		        new Staff("jack", 27, new BigDecimal("2000")),
		        new Staff("lawrence", 33, new BigDecimal(3000))
		);

		// --- BEFORE JAVA 8 ---
		final List<String> result = new ArrayList<>();
		for (final Staff x : staff)
		{
			result.add(x.getName());
		}
		System.out.println(result);

		System.out.println("--------------------------------------------");

		// --- JAVA 8 ---
		final List<String> resultJava8 = staff.stream().map(Staff::getName).collect(Collectors.toList());
		System.out.println(resultJava8);
	}
}
