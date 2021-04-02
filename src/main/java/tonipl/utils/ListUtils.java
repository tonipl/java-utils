package tonipl.utils;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import tonipl.model.Common;

public class ListUtils {

    private ListUtils() {
    }

    public static void sortById(List<Common> listToSort) throws IllegalArgumentException {
        if (CollectionUtils.isNotEmpty(listToSort)) {
            listToSort.sort((common1, common2) -> common1.getId().compareTo(common2.getId()));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void sortByCreationAuthor(List<Common> listToSort) throws IllegalArgumentException {
        if (CollectionUtils.isNotEmpty(listToSort)) {
            listToSort.sort((common1, common2) -> common1.getCreationAuthor().compareTo(common2.getCreationAuthor()));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void sortByCreationDate(List<Common> listToSort) throws IllegalArgumentException {
        if (CollectionUtils.isNotEmpty(listToSort)) {
            listToSort.sort((common1, common2) -> common1.getCreationDate().compareTo(common2.getCreationDate()));

        } else {
            throw new IllegalArgumentException();
        }
    }
}
