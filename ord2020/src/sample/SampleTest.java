package sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SampleTest {

	@Test
	public void testSample() {
		assertEquals("Hello", Sample.hello());
	}
}
