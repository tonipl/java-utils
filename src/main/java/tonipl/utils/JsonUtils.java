package tonipl.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private JsonUtils() {
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> transformJSONToMap(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
    }

    public static String transformMapToJson(Map<String, Object> map) throws JsonProcessingException {
		if (MapUtils.isEmpty(map)) {
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
