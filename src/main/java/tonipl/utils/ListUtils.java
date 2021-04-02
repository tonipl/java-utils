package tonipl.utils;

import java.util.List;

import org.springframework.util.Assert;

import tonipl.model.Common;

public class ListUtils {
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
}
