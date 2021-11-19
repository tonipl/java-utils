package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import tonipl.exceptions.CustomException;
import tonipl.model.Common;

public class FileUtilsTest {

	@Test
	public void testTransformFileToObjectWhenFileExists() {
		String filename = "Common.json";
		Common result = FileUtils.transformFileToObject(filename, Common.class);

		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(notNullValue()));
		assertThat(result.getCreationAuthor(), is(notNullValue()));
		assertThat(result.getModificationAuthor(), is(notNullValue()));
		assertThat(result.getModificationAuthor(), is(notNullValue()));
		assertThat(result.getModificationDate(), is(notNullValue()));
	}

	@Test(expected = CustomException.class)
	public void testTransformFileToObjectWhenFileNotExists() {
		String filename = "Foo";
		FileUtils.transformFileToObject(filename, Common.class);
	}

	@Test(expected = CustomException.class)
	public void testTransformFileToObjectWhenNullFile() {
		FileUtils.transformFileToObject(null, Common.class);
	}

	@Test(expected = CustomException.class)
	public void testTransformFileToObjectWhenNullTargetObject() {
		String filename = "Foo";
		FileUtils.transformFileToObject(filename, null);
	}
}
