package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testGetNullOrValueWithNull() {
		final String string = null;
		final String expected = null;
		final String result = StringUtils.getNullOrValue(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetNullOrValueWithEmpty() {
		final String string = "";
		final String expected = null;
		final String result = StringUtils.getNullOrValue(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetNullOrValueWithNotEmpty() {
		final String string = "Foo";
		final String expected = string;
		final String result = StringUtils.getNullOrValue(string);

		assertThat(result, is(expected));
	}
}
