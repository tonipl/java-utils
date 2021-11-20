package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {

	private static final String FOO = "Foo";
	private static final String EMPTY = "";

	@Test
	public void testGetNullOrValueWithNull() {
		final String string = null;
		final String expected = null;
		final String result = StringUtils.getNullOrValue(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetNullOrValueWithEmpty() {
		final String expected = null;
		final String result = StringUtils.getNullOrValue(EMPTY);

		assertThat(result, is(expected));
	}

	@Test
	public void testGetNullOrValueWithNotEmpty() {
		final String expected = FOO;
		final String result = StringUtils.getNullOrValue(FOO);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNumbersWithNull() {
		final boolean expected = false;
		final boolean result = StringUtils.hasNumbers(null);

		assertThat(result, is(expected));
	}

	@ParameterizedTest
	@ValueSource(strings = { EMPTY, FOO })
	void testHasNumbersWithoutNumbers(String arg) {
		final boolean expected = false;
		final boolean result = StringUtils.hasNumbers(arg);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNumbersWithNumbers() {
		final boolean expected = true;
		final boolean result = StringUtils.hasNumbers(FOO + "1");

		assertThat(result, is(expected));
	}

	@Test
	public void testHasAccentsWithNull() {
		final boolean expected = false;
		final boolean result = StringUtils.hasAccents(null);

		assertThat(result, is(expected));
	}

	@ParameterizedTest
	@ValueSource(strings = { EMPTY, FOO })
	void testHasAccentsWithoutAccents(String arg) {
		final boolean expected = false;
		final boolean result = StringUtils.hasAccents(arg);

		assertThat(result, is(expected));
	}

	@ParameterizedTest
	@ValueSource(strings = { "FOó", "FOÓ" })
	void testHasAccentsWithAccents(String arg) {
		final boolean expected = true;
		final boolean result = StringUtils.hasAccents(arg);

		assertThat(result, is(expected));
	}

	@Test
    public void testHasSpecialCharactersWithNull() {
        final boolean expected = false;
        final boolean result = StringUtils.hasSpecialCharacters(null);
        
        assertThat(result, is(expected));
    }

	@ParameterizedTest
	@ValueSource(strings = { EMPTY, FOO })
	void testHasSpecialCharactersWithoutSpecialCharacters(String arg) {
    	final boolean expected = false;
		final boolean result = StringUtils.hasSpecialCharacters(arg);
        
        assertThat(result, is(expected));
    }

	@ParameterizedTest
	@ValueSource(strings = { "FO¡O", "FO*O", "FO?O", "FO´O", "FO:O", "FO.O", "FO;O" })
	void testHasSpecialCharactersWithSpecialCharacters(String arg) {
    	final boolean expected = true;

		boolean result = StringUtils.hasSpecialCharacters(arg);
        assertThat(result, is(expected));
    }

	@Test
	public void testIsValidEmailWithNullEmail() {
		boolean expected = false;
		boolean result = StringUtils.isValidEmail(null);

		assertThat(result, is(expected));
	}

	@ParameterizedTest
	@ValueSource(strings = { EMPTY, FOO, "foo@" })
	void testIsValidEmailWithWrongEmail(String arg) {
		boolean expected = false;
		boolean result = StringUtils.isValidEmail(arg);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsValidEmailWithCorrectEmail() {
		boolean expected = true;
		boolean result = StringUtils.isValidEmail("foo@company.com");

		assertThat(result, is(expected));
	}
}
