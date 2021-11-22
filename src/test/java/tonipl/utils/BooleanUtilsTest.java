package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class BooleanUtilsTest {

	@Test
	public void testGetValueOrDefaultValueIfNullValueWithNullValue() {
		final Boolean expected = Boolean.FALSE;
		final Boolean value = null;
		final Boolean valueByDefault = false;

		final Boolean result = BooleanUtils.getValueOrDefaultValueIfNullValue(value, valueByDefault);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetValueOrDefaultValueIfNullValueWithValue() {
		final Boolean expected = Boolean.TRUE;
		final Boolean value = true;
		final Boolean valueByDefault = false;
		
		final Boolean result = BooleanUtils.getValueOrDefaultValueIfNullValue(value, valueByDefault);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetValueOrDefaultValueIfNullValueWithNullValueByDefault() {
		final Boolean expected = Boolean.FALSE;
		final Boolean value = false;
		final Boolean valueByDefault = null;
		
		final Boolean result = BooleanUtils.getValueOrDefaultValueIfNullValue(value, valueByDefault);

		assertThat(result, is(expected));
	}
}
