package tonipl.factories;

import tonipl.model.Common;

/**
 * A factory for creating Common objects.
 */
public class CommonFactory {

	private CommonFactory() {
	}


	/**
	 * Gets a Common object.
	 * 
	 * @return the Common object
	 */
	public static Common getCommonById(final Long id) {
		String creationAuthor = "Creation author " + id;

		Common common = new Common();
		common.setId(id);
		common.setCreationAuthor(creationAuthor);

		return common;
	}
}
