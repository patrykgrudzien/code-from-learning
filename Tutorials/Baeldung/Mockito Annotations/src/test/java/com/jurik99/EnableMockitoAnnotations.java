package com.jurik99;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/*
 * First - let's say how to enable the use of annotations with Mockito tests.
 *
 * In order for these annotations to be enabled, we'll need to AANNOTATE THE JUNIT TEST WITH A RUNNER -
 * "MockitoJUnitRunner" as in the following example:
 */
@RunWith(MockitoJUnitRunner.class)
public class EnableMockitoAnnotations
{

}

class EnableMockitoAnnotationsAlternatively
{
	/*
	 * Alternatively, we can ENABLE THESE ANNOTATIONS PROGRAMMATICALLY as well, by invoking:
	 * "MockitoAnnotations.initMocks()" as in the following example:
	 */
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
}
