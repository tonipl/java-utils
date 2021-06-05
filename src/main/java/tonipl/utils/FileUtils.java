package tonipl.utils;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tonipl.exceptions.CustomException;

public class FileUtils {

	private FileUtils() {
    }

	/**
	 * Transforms the resource file to an object.
	 *
	 * @param filename the file name
	 * @param target   the object to be transformed the resource file
	 * @return the object from a resource file
	 */
	public static <T> T transformFileToObject(final String filename, final Class<T> target) {
		T result = null;

		try {
			final Resource resource = new ClassPathResource(filename);
			final InputStream inputStream = resource.getInputStream();

			if (It.isNotNull(inputStream)) {
				final ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				result = objectMapper.readValue(inputStream, target);
			}
		} catch (JsonParseException | JsonMappingException jsonException) {
			throw new CustomException(jsonException);
		} catch (final IOException ioException) {
			throw new CustomException(ioException);
		}

		return result;
    }
}
