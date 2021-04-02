package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tonipl.model.Common;

public class ListUtilsTest {
    private List<Common> commons;

    private Common common1;
    private Common common2;
    private Common common3;

    @Before
    public void init() {
        initCommon1();
        initCommon2();
        initCommon3();

        commons = new ArrayList<>();
        commons.add(common3);
        commons.add(common1);
        commons.add(common2);
    }

    private void initCommon1() {
        Long id1 = 1L;
        String creationAuthor1 = "Creation author 1";

        common1 = new Common();
        common1.setId(id1);
        common1.setCreationAuthor(creationAuthor1);
    }

    private void initCommon2() {
        Long id2 = 2L;
        String creationAuthor2 = "Creation author 2";

        common2 = new Common();
        common2.setId(id2);
        common2.setCreationAuthor(creationAuthor2);
    }

    private void initCommon3() {
        Long id3 = 3L;
        String creationAuthor3 = "Creation author 3";

        common3 = new Common();
        common3.setId(id3);
        common3.setCreationAuthor(creationAuthor3);
    }

    @Test
    public void testSortById() {
        List<Common> expected = new ArrayList<>();
        expected.add(common1);
        expected.add(common2);
        expected.add(common3);

        ListUtils.sortById(commons);

        assertThat(commons.size(), is(3));
        assertThat(commons, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortByIdWithNullList() {
        ListUtils.sortById(null);
    }

    @Test
    public void testSortByCreationAuthor() {
        List<Common> expected = new ArrayList<>();
        expected.add(common1);
        expected.add(common2);
        expected.add(common3);

        ListUtils.sortByCreationAuthor(commons);

        assertThat(commons.size(), is(3));
        assertThat(commons, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortByCreationAuthorWithEmptyList() {
        List<Common> tmpCommons = new ArrayList<>();

        ListUtils.sortByCreationAuthor(tmpCommons);
    }

    @Test
    public void testSortByCreationDate() {
        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        Instant tomorrow = now.plus(1, ChronoUnit.DAYS);

        common3.setCreationDate(Date.from(now));
        common1.setCreationDate(Date.from(tomorrow));
        common2.setCreationDate(Date.from(yesterday));

        List<Common> expected = new ArrayList<>();
        expected.add(common2);
        expected.add(common3);
        expected.add(common1);

        ListUtils.sortByCreationDate(commons);

        assertThat(commons.size(), is(3));
        assertThat(commons, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortByCreationDateWithNullList() {
        ListUtils.sortByCreationDate(null);
    }

    @Test
    public void testRemoveIfRepeatedIds() {
        Long id = 1L;
        common2.setId(id);
        common3.setId(id);

        List<Common> expected = new ArrayList<>();
        expected.add(common3);

        ListUtils.removeIfRepeatedIds(commons);

        assertThat(commons.size(), is(1));
        assertThat(commons, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIfRepeatedIdsWithNullList() {
        ListUtils.removeIfRepeatedIds(null);
    }
}
