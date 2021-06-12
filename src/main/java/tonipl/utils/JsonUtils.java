package tonipl.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtils {

    private JsonUtils() {
    }

	/**
	 * Transforms a JSON in a map.
	 * 
	 * @param json the JSON
	 * @return a map
	 * @throws IOException
	 */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> transformJSONToMap(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, Map.class);
		} catch (final IOException e) {
			e.printStackTrace();
			throw e;
		}
    }

	/**
	 * Transforms a JSON to an object.
	 * 
	 * @param <T>
	 * @param json        the JSON
	 * @param objectClass the object
	 * @return the object from a JSON
	 */
	public static <T> T transformJSONToObject(final String json, final Class<T> objectClass) throws IOException {
		T result = null;

		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(json.getBytes(), objectClass);
		} catch (final IOException e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	/**
	 * Transforms a map in a JSON.
	 * 
	 * @param map the map
	 * @return a JSON
	 * @throws JsonProcessingException
	 */
    public static String transformMapToJson(Map<String, Object> map) throws JsonProcessingException {
		if (MapUtils.isEmpty(map)) {
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(map);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Transforms an object to a JSON.
	 *
	 * @param object the object
	 * @return a JSON
	 * @throws JsonProcessingException
	 */
	public static String transformObjectToJson(final Object object) throws JsonProcessingException {
		final StringBuilder result = new StringBuilder();

		try {
			final ObjectMapper objectMapper = new ObjectMapper();
			final ObjectWriter writer = objectMapper.writer().withDefaultPrettyPrinter();
			result.append(writer.writeValueAsString(object));
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
			throw e;
		}

		return result.toString();
	}
}
