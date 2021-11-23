package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ItTest {

	private static final String NOT_EMPTY_TEXT = "Foo";

	@Test
	public void testIsNullWithNullObject() {
		final String text = null;
		final boolean expected = true;
		final boolean result = It.isNull(text);

		assertThat(result, is(expected));
	}

	@ParameterizedTest
	@ValueSource(strings = { StringUtils.EMPTY, NOT_EMPTY_TEXT })
	void testIsNullWithNotNullObject(String arg) {
		final boolean expected = false;
		final boolean result = It.isNull(arg);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotNullWithNullObject() {
		final String text = null;
		final boolean expected = false;
		final boolean result = It.isNotNull(text);

		assertThat(result, is(expected));
	}

	@ParameterizedTest
	@ValueSource(strings = { StringUtils.EMPTY, NOT_EMPTY_TEXT })
	void testIsNotNullWithNotNullObject(String arg) {
		final boolean expected = true;
		final boolean result = It.isNotNull(arg);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithNullCollection() {
		final Collection<Object> collection = null;
		final boolean expected = true;
		final boolean result = It.isEmpty(collection);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithEmptyCollection() {
		final Collection<Object> collection = new ArrayList<>();
		final boolean expected = true;
		final boolean result = It.isEmpty(collection);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithNotEmptyCollection() {
		final Collection<Object> collection = new ArrayList<>();
		collection.add(NOT_EMPTY_TEXT);
		final boolean expected = false;
		final boolean result = It.isEmpty(collection);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithNullCollection() {
		final Collection<Object> collection = null;
		final boolean expected = false;
		final boolean result = It.isNotEmpty(collection);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithEmptyCollection() {
		final Collection<Object> collection = new ArrayList<>();
		final boolean expected = false;
		final boolean result = It.isNotEmpty(collection);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithNotEmptyCollection() {
		final Collection<Object> collection = new ArrayList<>();
		collection.add(NOT_EMPTY_TEXT);
		final boolean expected = true;
		final boolean result = It.isNotEmpty(collection);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithNullMap() {
		final Map<Object, Object> map = null;
		final boolean expected = true;
		final boolean result = It.isEmpty(map);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithEmptyMap() {
		final Map<Object, Object> map = new HashMap<>();
		final boolean expected = true;
		final boolean result = It.isEmpty(map);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithNotEmptyMap() {
		final Map<Object, Object> map = new HashMap<>();
		map.put(1, NOT_EMPTY_TEXT);

		final boolean expected = false;
		final boolean result = It.isEmpty(map);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithNullMap() {
		final Map<Object, Object> map = null;
		final boolean expected = false;
		final boolean result = It.isNotEmpty(map);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithEmptyMap() {
		final Map<Object, Object> map = new HashMap<>();
		final boolean expected = false;
		final boolean result = It.isNotEmpty(map);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithNotEmptyMap() {
		final Map<Object, Object> map = new HashMap<>();
		map.put(1, NOT_EMPTY_TEXT);

		final boolean expected = true;
		final boolean result = It.isNotEmpty(map);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithNullArray() {
		final Object[] array = null;
		final boolean expected = true;
		final boolean result = It.isEmpty(array);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithEmptyArray() {
		final Object[] array = new Object[0];
		final boolean expected = true;
		final boolean result = It.isEmpty(array);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsEmptyWithNotEmptyArray() {
		final Object[] array = new Object[1];
		array[0] = 1L;

		final boolean expected = false;
		final boolean result = It.isEmpty(array);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithNullArray() {
		final Object[] array = null;
		final boolean expected = false;
		final boolean result = It.isNotEmpty(array);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithEmptyArray() {
		final Object[] array = new Object[0];
		final boolean expected = false;
		final boolean result = It.isNotEmpty(array);

		assertThat(result, is(expected));
	}

	@Test
	public void testIsNotEmptyWithNotEmptyArray() {
		final Object[] array = new Object[1];
		array[0] = StringUtils.EMPTY;

		final boolean expected = true;
		final boolean result = It.isNotEmpty(array);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasTextWithNullString() {
		final String string = null;
		final boolean expected = false;
		final boolean result = It.hasText(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasTextWithEmptyString() {
		final String string = StringUtils.EMPTY;
		final boolean expected = false;
		final boolean result = It.hasText(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasTextWithNotEmptyString() {
		final String string = NOT_EMPTY_TEXT;
		final boolean expected = true;
		final boolean result = It.hasText(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNotTextWithNullString() {
		final String string = null;
		final boolean expected = true;
		final boolean result = It.hasNotText(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNotTextWithEmptyString() {
		final String string = StringUtils.EMPTY;
		final boolean expected = true;
		final boolean result = It.hasNotText(string);

		assertThat(result, is(expected));
	}

	@Test
	public void testHasNotTextWithNotEmptyString() {
		final String string = NOT_EMPTY_TEXT;
		final boolean expected = false;
		final boolean result = It.hasNotText(string);

		assertThat(result, is(expected));
	}
}
