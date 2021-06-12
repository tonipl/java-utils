package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

import tonipl.model.Common;

public class JsonUtilsTest {
	private String language;
	private String version;
	private Long id;
	private String author;
	private String json;

	@Before
	public void init() {
		language = "language";
		version = "version";
		id = Long.valueOf(1);
		author = "Foo";
		json = "{\n  \"id\" : " + id + ",\n  \"creationAuthor\" : \"" + author + "\",\n  \"modificationAuthor\" : \""
				+ author + "\",\n  \"creationDate\" : null,\n  \"modificationDate\" : null\n}";
	}

    @Test
    public void testTransformJSONToMap() throws IOException {
		final String json = "{\"language\":\"Java\",\"version\":\"8\"}";

		final Map<String, Object> map = JsonUtils.transformJSONToMap(json);

		final Map<String, String> expected = new HashMap<>();
		expected.put(language, "Java");
		expected.put(version, "8");

		assertThat(map, is(expected));
		assertThat(map.size(), is(2));
		assertThat(map, IsMapContaining.hasEntry(language, "Java"));
		assertThat(map, not(IsMapContaining.hasEntry(language, "PHP")));
		assertThat(map, IsMapContaining.hasKey(version));
		assertThat(map, IsMapContaining.hasValue("8"));
    }

    @Test(expected = IllegalArgumentException.class)
	public void testTransformJSONToMapWithIllegalArgumentException() throws IOException {
		JsonUtils.transformJSONToMap(null);
    }

    @Test(expected = JsonParseException.class)
    public void testTransformJSONToMapWithWrongJson() throws IOException {
		final String wrongJson = "{\"language\":\"Java\"\"version\":\"8\"}";
		JsonUtils.transformJSONToMap(wrongJson);
    }

    @Test
	public void testTransformJSONToObject() throws IOException {
		Common result = JsonUtils.transformJSONToObject(json, Common.class);

		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(id));
		assertThat(result.getCreationAuthor(), is(author));
		assertThat(result.getModificationAuthor(), is(author));
    }

	@Test(expected = IOException.class)
	public void testTransformJSONToObjectWithWrongJson() throws IOException {
		final String wrongJson = "{wrong: json}";
		JsonUtils.transformJSONToObject(wrongJson, Common.class);
	}

	@Test
    public void testTransformMapToJson() throws JsonProcessingException {
		String expected = "{\"language\":\"Java\",\"version\":\"8\"}";

		Map<String, Object> map = new HashMap<>();
		map.put(language, "Java");
		map.put(version, "8");

		final String result = JsonUtils.transformMapToJson(map);
		assertThat(result, is(expected));
    }

    @Test
    public void testTransformNullMapToJson() throws JsonProcessingException {
		String result = JsonUtils.transformMapToJson(null);
		assertThat(result, is(nullValue()));
    }

	@Test
	public void testTransformObjectToJson() throws JsonProcessingException {
		final Common common = new Common();
		common.setId(id);
		common.setCreationAuthor(author);
		common.setModificationAuthor(author);

		final String result = JsonUtils.transformObjectToJson(common);

		assertThat(result, is(json));
	}
}
