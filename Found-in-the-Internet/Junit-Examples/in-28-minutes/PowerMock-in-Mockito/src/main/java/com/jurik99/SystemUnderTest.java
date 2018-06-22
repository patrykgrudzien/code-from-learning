package com.jurik99;

import java.util.ArrayList;
import java.util.List;

interface Dependency {
	List<Integer> retrieveAllStats();
}

class UtilityClass {
	static int staticMethod(final long value) {
		// some comples logic here...
		throw new RuntimeException("I don't want to be executed.");
	}
}

public class SystemUnderTest {
	private Dependency dependency;

	public int methodUsingAnArrayListConstructor() {
		final ArrayList list = new ArrayList();
		return list.size();
	}

	public int methodCallingStaticMethod() {
		final List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;

		for (final int stat : stats) {
			sum += stat;
		}
		return UtilityClass.staticMethod(sum);
	}

	private long privateMethodUnderTest() {
		final List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;

		for (final int stat : stats) {
			sum += stat;
		}
		return sum;
	}
}
