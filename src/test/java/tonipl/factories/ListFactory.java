package tonipl.factories;

import java.util.ArrayList;
import java.util.List;

import tonipl.model.Common;

/**
 * A factory for creating lists.
 */
public final class ListFactory {

	private ListFactory() {
	}

	public static List<Common> getCommonList() {
		final List<Common> commons = new ArrayList<>();
		commons.add(CommonFactory.getCommonById(1L));
		commons.add(CommonFactory.getCommonById(2L));
		commons.add(CommonFactory.getCommonById(3L));

		return commons;
	}
}
