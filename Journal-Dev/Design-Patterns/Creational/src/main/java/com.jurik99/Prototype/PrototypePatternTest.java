package com.jurik99.Prototype;

import java.util.List;

public class PrototypePatternTest {

	public static void main(final String[] args) throws CloneNotSupportedException {
		final Employees emps = new Employees();
		emps.loadData();

		//Use the clone method to get the Employee object
		final Employees empsNew = (Employees) emps.clone();
		final Employees empsNew1 = (Employees) emps.clone();

		final List<String> list = empsNew.getEmpList();
		list.add("John");

		final List<String> list1 = empsNew1.getEmpList();
		list1.remove("Pankaj");

		System.out.println("emps List: " + emps.getEmpList());
		System.out.println("empsNew List: " + empsNew.getEmpList());
		System.out.println("empsNew1 List: " + empsNew1.getEmpList());
	}
}
