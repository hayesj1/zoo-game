package util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestUtils {
	public static void testArrayEquals(float[] expected, float[] actual) {
		assertArrayEquals(expected, actual, 0.0001f);
	}

	public static void testEquals(float expected, float actual) {
		assertEquals(expected, actual, 0.0001f);
	}
}
