package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonUtilsTest {
    private static final String LANGUAGE = "language";
    private static final String VERSION = "version";

    @Test
    public void testTransformJSONToMap() throws IOException {
	String json = "{\"language\":\"Java\",\"version\":\"8\"}";

	Map<String, Object> map = JsonUtils.transformJSONToMap(json);

	Map<String, String> expected = new HashMap<>();
	expected.put(LANGUAGE, "Java");
	expected.put(VERSION, "8");

	assertThat(map, is(expected));
	assertThat(map.size(), is(2));
	assertThat(map, IsMapContaining.hasEntry(LANGUAGE, "Java"));
	assertThat(map, not(IsMapContaining.hasEntry(LANGUAGE, "ruby")));
	assertThat(map, IsMapContaining.hasKey(VERSION));
	assertThat(map, IsMapContaining.hasValue("8"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransformJSONToMapWithIllegalArgumentException() throws IOException {
	JsonUtils.transformJSONToMap(null);
    }

    @Test(expected = JsonParseException.class)
    public void testTransformJSONToMapWithWrongJson() throws IOException {
	String wrongJson = "{\"language\":\"Java\"\"version\":\"8\"}";
	JsonUtils.transformJSONToMap(wrongJson);
    }

    @Test
    public void testTransformMapToJson() throws JsonProcessingException {
	String expected = "{\"language\":\"Java\",\"version\":\"8\"}";

	Map<String, Object> map = new HashMap<>();
	map.put(LANGUAGE, "Java");
	map.put(VERSION, "8");

	String json = JsonUtils.transformMapToJson(map);
	assertThat(json, is(expected));
    }

    @Test
    public void testTransformNullMapToJson() throws JsonProcessingException {
	String json = JsonUtils.transformMapToJson(null);
	assertThat(json, is(nullValue()));
    }
}