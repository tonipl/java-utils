package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

import tonipl.exceptions.CustomException;

public class PreconditionsTest {
	private static final String EMPTY_TEXT = "";
	private static final String NON_EMPTY_TEXT = "Test";
	private static final String ERROR_MESSAGE = "Error message";
	private static final String PARAM = "Param";

	@Test(expected = CustomException.class)
	public void testCheckIsNotNullWithNull() {
		final Object object = null;
		Preconditions.checkIsNotNull(object, ERROR_MESSAGE);
	}

	@Test
	public void testCheckIsNotNullWithNotNull() {
		Preconditions.checkIsNotNull(EMPTY_TEXT, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckIsNotNullWithNullAndParams() {
		final Object object = null;
		Preconditions.checkIsNotNull(object, ERROR_MESSAGE, PARAM);
	}

	@Test
	public void testCheckIsNotNullWithNotNullAndParams() {
		Preconditions.checkIsNotNull(EMPTY_TEXT, ERROR_MESSAGE, PARAM);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfNotPresentWithNull() {
		Preconditions.checkIfNotPresent(null, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfNotPresentWithPresent() {
		final Optional<String> optional = Optional.of(EMPTY_TEXT);
		Preconditions.checkIfNotPresent(optional, ERROR_MESSAGE);
	}

	@Test
	public void testCheckIfNotPresentWithOptionalOfNullable() {
		final Optional<String> optional = Optional.ofNullable(null);
		final Object result = Preconditions.checkIfNotPresent(optional, ERROR_MESSAGE);

		assertNull(result);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfNotPresentWithNullAndParams() {
		Preconditions.checkIfNotPresent(null, ERROR_MESSAGE, PARAM);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfNotPresentWithPresentAndParams() {
		final Optional<String> optional = Optional.of(EMPTY_TEXT);
		Preconditions.checkIfNotPresent(optional, ERROR_MESSAGE, PARAM);
	}

	@Test
	public void testCheckIfNotPresentWithOptionalOfNullableAndParams() {
		final Optional<String> optional = Optional.ofNullable(null);
		final Object result = Preconditions.checkIfNotPresent(optional, ERROR_MESSAGE, PARAM);

		assertNull(result);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfPresentWithOptionalOfNullable() {
		final Optional<String> optional = Optional.ofNullable(null);
		final Object result = Preconditions.checkIfPresent(optional, ERROR_MESSAGE);

		assertNull(result);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfPresentWithNull() {
		Preconditions.checkIfPresent(null, ERROR_MESSAGE);
	}

	@Test
	public void testCheckIfPresentWithPresent() {
		final Optional<String> optional = Optional.of(EMPTY_TEXT);
		final String result = Preconditions.checkIfPresent(optional, ERROR_MESSAGE);

		assertThat(result, is(EMPTY_TEXT));
	}

	@Test(expected = CustomException.class)
	public void testCheckIfPresentWithOptionalOfNullableAndParams() {
		final Optional<String> optional = Optional.ofNullable(null);
		final Object result = Preconditions.checkIfPresent(optional, ERROR_MESSAGE, PARAM);

		assertNull(result);
	}

	@Test(expected = CustomException.class)
	public void testCheckIfPresentWithNullAndParams() {
		Preconditions.checkIfPresent(null, ERROR_MESSAGE, PARAM);
	}

	@Test
	public void testCheckIfPresentWithPresentAndParams() {
		final Optional<String> optional = Optional.of(EMPTY_TEXT);
		final String result = Preconditions.checkIfPresent(optional, ERROR_MESSAGE, PARAM);

		assertThat(result, is(EMPTY_TEXT));
	}

	@Test(expected = CustomException.class)
	public void testCheckIsNotEmptyStringWithNull() {
		Preconditions.checkStringIsNotEmpty(null, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckIsNotEmptyStringWithEmpty() {
		Preconditions.checkStringIsNotEmpty(EMPTY_TEXT, ERROR_MESSAGE);
	}

	@Test
	public void testCheckIsNotEmptyStringWithValue() {
		Preconditions.checkStringIsNotEmpty(NON_EMPTY_TEXT, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckIsNotEmptyStringWithNullWithParams() {
		Preconditions.checkStringIsNotEmpty(null, ERROR_MESSAGE, PARAM);
	}

	@Test(expected = CustomException.class)
	public void testCheckIsNotEmptyStringWithEmptyWithParams() {
		Preconditions.checkStringIsNotEmpty(EMPTY_TEXT, ERROR_MESSAGE, PARAM);
	}

	@Test
	public void testCheckIsNotEmptyStringWithValueWithParams() {
		Preconditions.checkStringIsNotEmpty(NON_EMPTY_TEXT, ERROR_MESSAGE, PARAM);
	}
	
	@Test(expected = CustomException.class)
	public void testCheckCollectionIsNotEmptyWithNull() {
		final Collection<Object> collection = null;
		Preconditions.checkCollectionIsNotEmpty(collection, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckCollectionIsNotEmptyWithEmpty() {
		final Collection<Object> collection = new HashSet<>();
		Preconditions.checkCollectionIsNotEmpty(collection, ERROR_MESSAGE);
	}

	@Test
	public void testCheckCollectionIsNotEmptyWithValue() {
		final Collection<Object> collection = new HashSet<>();
		collection.add(NON_EMPTY_TEXT);

		Preconditions.checkCollectionIsNotEmpty(collection, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckCollectionIsNotEmptyWithNullWithParams() {
		final Collection<Object> collection = null;
		Preconditions.checkCollectionIsNotEmpty(collection, ERROR_MESSAGE, PARAM);
	}

	@Test(expected = CustomException.class)
	public void testCheckCollectionIsNotEmptyWithEmptyWithParams() {
		final Collection<Object> collection = new HashSet<>();
		Preconditions.checkCollectionIsNotEmpty(collection, ERROR_MESSAGE, PARAM);
	}

	@Test
	public void testCheckCollectionIsNotEmptyWithValueWithParams() {
		final Collection<Object> collection = new HashSet<>();
		collection.add(NON_EMPTY_TEXT);

		Preconditions.checkCollectionIsNotEmpty(collection, ERROR_MESSAGE, PARAM);
	}

	@Test(expected = CustomException.class)
	public void testCheckMapIsNotEmptyWithNull() {
		final Map<Object, Object> map = null;
		Preconditions.checkMapIsNotEmpty(map, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckMapIsNotEmptyWithEmpty() {
		final Map<Object, Object> map = new HashMap<>();
		Preconditions.checkMapIsNotEmpty(map, ERROR_MESSAGE);
	}

	@Test
	public void testCheckMapIsNotEmptyWithValue() {
		final Map<Object, Object> map = new HashMap<>();
		map.put(0, NON_EMPTY_TEXT);

		Preconditions.checkMapIsNotEmpty(map, ERROR_MESSAGE);
	}

	@Test(expected = CustomException.class)
	public void testCheckMapIsNotEmptyWithNullWithParams() {
		final Map<Object, Object> map = null;
		Preconditions.checkMapIsNotEmpty(map, ERROR_MESSAGE, PARAM);
	}

	@Test(expected = CustomException.class)
	public void testCheckMapIsNotEmptyWithEmptyWithParams() {
		final Map<Object, Object> map = new HashMap<>();
		Preconditions.checkMapIsNotEmpty(map, ERROR_MESSAGE, PARAM);
	}

	@Test
	public void testCheckMapIsNotEmptyWithValueWithParams() {
		final Map<Object, Object> map = new HashMap<>();
		map.put(0, NON_EMPTY_TEXT);

		Preconditions.checkMapIsNotEmpty(map, ERROR_MESSAGE, PARAM);
	}
}
