package tonipl.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import tonipl.constants.CommonErrors;
import tonipl.model.Common;

/**
 * Utility for lists.
 */
public class ListUtils {

    private ListUtils() {
    }


    /**
     * Sorts by identifier a list of Common objects.
     * 
     * @param listToSort the list to sort
     */
	public static void sortById(List<Common> listToSort) {
		Preconditions.checkCollectionIsNotEmpty(listToSort, CommonErrors.LIST_EMPTY.getError());

        listToSort.sort((common1, common2) -> common1.getId().compareTo(common2.getId()));
    }

    /**
	 * Sorts by creation author a list of Common objects.
	 * 
	 * @param listToSort the list to sort
	 */
	public static void sortByCreationAuthor(List<Common> listToSort) {
		Preconditions.checkCollectionIsNotEmpty(listToSort, CommonErrors.LIST_EMPTY.getError());

        listToSort.sort((common1, common2) -> common1.getCreationAuthor().compareTo(common2.getCreationAuthor()));
    }

	/**
	 * Sorts by creation date a list of Common objects.
	 * 
	 * @param listToSort the list to sort
	 */
	public static void sortByCreationDate(List<Common> listToSort) {
		Preconditions.checkCollectionIsNotEmpty(listToSort, CommonErrors.LIST_EMPTY.getError());

        listToSort.sort((common1, common2) -> common1.getCreationDate().compareTo(common2.getCreationDate()));
    }

	/**
	 * Removes those Common objects from a list that they are repeated by
	 * identifier.
	 * 
	 * @param list the Common list
	 */
    public static void removeIfRepeatedIds(List<Common> list) {
		Preconditions.checkCollectionIsNotEmpty(list, CommonErrors.LIST_EMPTY.getError());

        HashSet<Object> seen = new HashSet<>();
        list.removeIf(common -> !seen.add(common.getId()));
    }

	/**
	 * Gets from a list that Common object with an identifier equal to the one
	 * passed by parameter.
	 * 
	 * @param id   the identifier
	 * @param list the list
	 * @return the Common ojbect
	 */
    public static Common findById(Long id, List<Common> list) {
		Preconditions.checkIsNotNull(id, CommonErrors.ID_NULL.getError());
		Preconditions.checkCollectionIsNotEmpty(list, CommonErrors.LIST_EMPTY.getError());

        Optional<Common> found = list.stream().filter(common -> id.equals(common.getId())).findFirst();
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }
}
