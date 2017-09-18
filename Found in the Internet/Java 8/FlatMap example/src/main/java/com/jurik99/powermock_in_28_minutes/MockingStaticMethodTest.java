package com.jurik99.powermock_in_28_minutes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(PowerMockRunner.class) // first requirement
@PrepareForTest(UtilityClass.class)   // second requirement
public class MockingStaticMethodTest
{
	/**
	 * When we want to combine MOCKITO and POWERMOCK we have to use SPECIFIC RUNNER class.
	 * Then we have to INITIALIZE "UtilityClass.class" (mock static method in that class).
	 * Last step is simply MOCK.
	 */

	@Mock
	private Dependency dependency;

	@InjectMocks
	private SystemUnderTest systemUnderTest;

	@Test
	public void test()
	{
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(dependency.retrieveAllStats()).thenReturn(stats);

		PowerMockito.mockStatic(UtilityClass.class);    // third requirement
		when(UtilityClass.staticMethod(5)).thenReturn(150);

		int result = systemUnderTest.methodCallingStaticMethod();
		assertEquals(150, result);

		// we wanna now check method invocation
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
		// it is a result of staticMethod() itself cause we provide list (1,2,3) and inside that method there is sum
	}
}
