package com.jurik99;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class MockingPrivateMethodTest {

	@Mock
	private Dependency dependency;

	@InjectMocks
	private SystemUnderTest systemUnderTest;

	@Test
	public void test() throws Exception {
		List<Integer> stats = Arrays.asList(1, 2, 3, 4);
		when(dependency.retrieveAllStats()).thenReturn(stats);

		long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		assertEquals(10, result);
	}
}
