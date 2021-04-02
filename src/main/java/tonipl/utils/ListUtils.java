package tonipl.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.util.Assert;

import tonipl.model.Common;

public class ListUtils {
    private static final String EXCEPTION_ID_NULL = "Id may not be empty";
    private static final String EXCEPTION_LIST_EMPTY = "List may not be empty";

    private ListUtils() {
    }

    public static void sortById(List<Common> listToSort) throws IllegalArgumentException {
        Assert.notEmpty(listToSort, EXCEPTION_LIST_EMPTY);

        listToSort.sort((common1, common2) -> common1.getId().compareTo(common2.getId()));
    }

    public static void sortByCreationAuthor(List<Common> listToSort) throws IllegalArgumentException {
        Assert.notEmpty(listToSort, EXCEPTION_LIST_EMPTY);

        listToSort.sort((common1, common2) -> common1.getCreationAuthor().compareTo(common2.getCreationAuthor()));
    }

    public static void sortByCreationDate(List<Common> listToSort) throws IllegalArgumentException {
        Assert.notEmpty(listToSort, EXCEPTION_LIST_EMPTY);

        listToSort.sort((common1, common2) -> common1.getCreationDate().compareTo(common2.getCreationDate()));
    }

    public static void removeIfRepeatedIds(List<Common> list) {
        Assert.notEmpty(list, EXCEPTION_LIST_EMPTY);

        HashSet<Object> seen = new HashSet<>();
        list.removeIf(common -> !seen.add(common.getId()));
    }

    public static Common findById(Long id, List<Common> list) {
        Assert.notNull(id, EXCEPTION_ID_NULL);
        Assert.notEmpty(list, EXCEPTION_LIST_EMPTY);

        Optional<Common> found = list.stream().filter(common -> id.equals(common.getId())).findFirst();
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }
}
