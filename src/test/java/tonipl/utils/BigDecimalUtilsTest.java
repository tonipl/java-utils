package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalUtilsTest {

	@Test
	public void testGetValueOrDefaultValueIfNullValueWithNullValue() {
		final BigDecimal expected = new BigDecimal(1);
		final BigDecimal value = null;
		final BigDecimal valueByDefault = new BigDecimal(1);

		final BigDecimal result = BigDecimalUtils.getValueOrDefaultValueIfNullValue(value, valueByDefault);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetValueOrDefaultValueIfNullValueWithValue() {
		final BigDecimal expected = new BigDecimal(1);
		final BigDecimal value = new BigDecimal(1);
		final BigDecimal valueByDefault = new BigDecimal(2);

		final BigDecimal result = BigDecimalUtils.getValueOrDefaultValueIfNullValue(value, valueByDefault);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetValueOrDefaultValueIfNullValueWithNullValueByDefault() {
		final BigDecimal expected = new BigDecimal(1);
		final BigDecimal value = new BigDecimal(1);
		final BigDecimal valueByDefault = null;

		final BigDecimal result = BigDecimalUtils.getValueOrDefaultValueIfNullValue(value, valueByDefault);

		assertThat(result, is(expected));
	}
}
