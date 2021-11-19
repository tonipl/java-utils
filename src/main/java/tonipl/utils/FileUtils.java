package tonipl.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tonipl.constants.FileErrors;
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
		Preconditions.checkStringIsNotEmpty(filename, FileErrors.FILENAME_NULL.getError());
		Preconditions.checkIsNotNull(target, FileErrors.TARGET_CLASS_NULL.getError());

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

	/**
	 * Creates a file with content in a specific path. If path doesn't exist, then
	 * it's created.
	 *
	 * @param path     the path
	 * @param filename the file name
	 * @param content  the content
	 * @throws IOException the I/O exception
	 */
	public static void createFileByBytes(final String path, final String filename, final byte[] content)
			throws IOException {

		Preconditions.checkStringIsNotEmpty(path, FileErrors.PATH_NULL.getError());
		Preconditions.checkStringIsNotEmpty(filename, FileErrors.FILENAME_NULL.getError());
		if (ArrayUtils.isEmpty(content)) {
			throw new CustomException(FileErrors.CONTENT_NULL.getError());
		}


		final Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
		if (!Files.exists(normalizedPath)) {
			Files.createDirectories(normalizedPath);
		}
		final Path targetLocation = normalizedPath.resolve(filename);

		Files.write(targetLocation, content, StandardOpenOption.CREATE_NEW);
	}

    /**
	 * Creates a file in a specific path with the content of a multipart file. If
	 * path doesn't exist, then it's created.
	 *
	 * @param path          the path
	 * @param multipartFile the multipart file
	 * @throws IOException the I/O exception
	 */
	public static void createFileByMultipart(final String path, final MultipartFile multipartFile) throws IOException {
		Preconditions.checkStringIsNotEmpty(path, FileErrors.PATH_NULL.getError());
		Preconditions.checkIsNotNull(multipartFile, FileErrors.MULTIPART_FILE_NULL.getError());

		final Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
		if (!Files.exists(normalizedPath)) {
			Files.createDirectories(normalizedPath);
        }

		final Path targetLocation = normalizedPath.resolve(getFilename(multipartFile));

		Files.write(targetLocation, multipartFile.getBytes(), StandardOpenOption.CREATE_NEW);
    }

	/**
	 * Gets the file name of a multipart file.
	 *
	 * @param multipartFile the multipart file
	 * @return the file name
	 */
	public static String getFilename(final MultipartFile multipartFile) {
		Preconditions.checkIsNotNull(multipartFile, FileErrors.MULTIPART_FILE_NULL.getError());

		final String extension = getFileExtension(multipartFile);
		final String filename = FilenameUtils.getBaseName(multipartFile.getOriginalFilename());
		return String.format("%s.%s", filename, extension);
	}

	/**
	 * Gets the file extension of a multipart file.
	 *
	 * @param multipartFile the multipart file
	 * @return the file extension
	 */
	public static String getFileExtension(final MultipartFile multipartFile) {
		Preconditions.checkIsNotNull(multipartFile, FileErrors.MULTIPART_FILE_NULL.getError());

		return FilenameUtils.getExtension(multipartFile.getOriginalFilename());
	}

	/**
	 * Creates a file in a specific path with the content of a MIME message. If path
	 * doesn't exist, then it's created.
	 *
	 * @param path        the path
	 * @param filename    the file name
	 * @param mimeMessage the MIME message
	 * @throws IOException        the I/O exception
	 * @throws MessagingException the messaging exception
	 */
	public static void createFileByMimeMessage(final String path, final String filename, final MimeMessage mimeMessage)
			throws IOException, MessagingException {

		Preconditions.checkStringIsNotEmpty(path, FileErrors.PATH_NULL.getError());
		Preconditions.checkStringIsNotEmpty(filename, FileErrors.FILENAME_NULL.getError());
		Preconditions.checkIsNotNull(mimeMessage, FileErrors.MIMEMESSAGE_FILE_NULL.getError());

		final Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
		if (!Files.exists(normalizedPath)) {
			Files.createDirectories(normalizedPath);
		}

		final Path targetLocation = normalizedPath.resolve(filename);
		mimeMessage.writeTo(new FileOutputStream(new File(targetLocation.toUri())));
	}

    /**
	 * Loads a file as resource.
	 *
	 * @param path     the path
	 * @param filename the file name
	 * @return the resource
	 */
	public static Resource loadFileAsResource(final String path, final String filename) {
		Preconditions.checkStringIsNotEmpty(path, FileErrors.PATH_NULL.getError());
		Preconditions.checkStringIsNotEmpty(filename, FileErrors.FILENAME_NULL.getError());

		final Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
		if (!Files.exists(normalizedPath)) {
			throw new CustomException(FileErrors.PATH_NOT_EXIST.getError(), path);
        }

		final Path filePath = normalizedPath.resolve(filename).normalize();
        return new FileSystemResource(filePath);
    }

    /**
	 * Deletes a resource/file.
	 *
	 * @param resource the resource
	 */
    public static void deleteFile(final Resource resource) {
		Preconditions.checkIsNotNull(resource, FileErrors.RESOURCE.getError());

		try {
            Files.delete(Paths.get(resource.getURI()));
        } catch (final IOException e) {
			throw new CustomException(FileErrors.CANNOT_DELETE_FILE.getError(), resource.getFilename());
        }
    }

    /**
	 * Deletes a directory.
	 *
	 * @param path the path
	 * @throws IOException the I/O exception
	 */
	public static void deleteDirectory(final String path) throws IOException {
		Preconditions.checkStringIsNotEmpty(path, FileErrors.PATH_NULL.getError());

		final Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
		if (!Files.exists(normalizedPath)) {
			throw new CustomException(FileErrors.PATH_NOT_EXIST.getError(), path);
        }

		org.apache.commons.io.FileUtils.deleteDirectory(normalizedPath.toFile());
    }

	/**
	 * Gets the size of a multipart file.
	 *
	 * @param multipartFile the multipart file
	 * @return the multipart file size
	 */
	public static Long getFileSize(final MultipartFile multipartFile) {
		Preconditions.checkIsNotNull(multipartFile, FileErrors.MULTIPART_FILE_NULL.getError());

		return multipartFile.getSize();
	}
}
