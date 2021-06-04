package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

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

	@Test
	public void testHasNumbersWithEmpty() {
		final boolean expected = false;
		final boolean result = StringUtils.hasNumbers(EMPTY);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNumbersWithoutNumber() {
		final boolean expected = false;
		final boolean result = StringUtils.hasNumbers(FOO);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNumbersWithNumber() {
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

	@Test
	public void testHasAccentsWithoutAccents() {
		final boolean expected = false;
		final boolean result = StringUtils.hasAccents(FOO);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasAccentsWithEmpty() {
		final boolean expected = false;
		final boolean result = StringUtils.hasAccents(EMPTY);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasAccentsWithLowercaseAccents() {
		final boolean expected = true;
		final boolean result = StringUtils.hasAccents("FOó");

		assertThat(result, is(expected));
	}

	@Test
	public void testHasAccentsWithUppercaseAccents() {
		final boolean expected = true;
		final boolean result = StringUtils.hasAccents("FOÓ");

		assertThat(result, is(expected));
	}

	@Test
    public void testHasSpecialCharactersWithNull() {
        final boolean expected = false;
        final boolean result = StringUtils.hasSpecialCharacters(null);
        
        assertThat(result, is(expected));
    }

    @Test
    public void testHasSpecialCharactersWithEmpty() {
    	final boolean expected = false;
        final boolean result = StringUtils.hasSpecialCharacters(EMPTY);
        
        assertThat(result, is(expected));
    }

    @Test
    public void testHasSpecialCharactersWithoutSpecialCharacters() {
    	final boolean expected = false;
    	final boolean result = StringUtils.hasSpecialCharacters(FOO);
        
        assertThat(result, is(expected));
    }

    @Test
    public void testHasSpecialCharactersWithSpecialCharacters() {
    	final boolean expected = true;

		boolean result = StringUtils.hasSpecialCharacters("FO¡O");
        assertThat(result, is(expected));

		result = StringUtils.hasSpecialCharacters("FO*O");
		assertThat(result, is(expected));

		result = StringUtils.hasSpecialCharacters("FO?O");
		assertThat(result, is(expected));

		result = StringUtils.hasSpecialCharacters("FO´O");
        assertThat(result, is(expected));

		result = StringUtils.hasSpecialCharacters("FO:O");
        assertThat(result, is(expected));

		result = StringUtils.hasSpecialCharacters("FO.O");
        assertThat(result, is(expected));

		result = StringUtils.hasSpecialCharacters("FO;O");
        assertThat(result, is(expected));
    }
}
