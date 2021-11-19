package tonipl.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tonipl.exceptions.CustomException;
import tonipl.factories.CommonFactory;
import tonipl.factories.ListFactory;
import tonipl.model.Common;

public class ListUtilsTest {
    private List<Common> commons;


    @Before
    public void init() {
		commons = ListFactory.getCommonList();
    }


    @Test
    public void testSortById() {
        List<Common> expected = new ArrayList<>();
		expected.add(CommonFactory.getCommonById(1L));
		expected.add(CommonFactory.getCommonById(2L));
		expected.add(CommonFactory.getCommonById(3L));

        ListUtils.sortById(commons);

        assertThat(commons.size(), is(3));
        assertThat(commons, is(expected));
    }

	@Test(expected = CustomException.class)
    public void testSortByIdWithNullList() {
        ListUtils.sortById(null);
    }

    @Test
    public void testSortByCreationAuthor() {
        List<Common> expected = new ArrayList<>();
		expected.add(CommonFactory.getCommonById(1L));
		expected.add(CommonFactory.getCommonById(2L));
		expected.add(CommonFactory.getCommonById(3L));

        ListUtils.sortByCreationAuthor(commons);

        assertThat(commons.size(), is(3));
        assertThat(commons, is(expected));
    }

	@Test(expected = CustomException.class)
    public void testSortByCreationAuthorWithEmptyList() {
        List<Common> tmpCommons = new ArrayList<>();

        ListUtils.sortByCreationAuthor(tmpCommons);
    }

    @Test
    public void testSortByCreationDate() {
        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        Instant tomorrow = now.plus(1, ChronoUnit.DAYS);

		Common common3 = commons.get(2);
		common3.setCreationDate(Date.from(now));

		Common common1 = commons.get(0);
		common1.setCreationDate(Date.from(tomorrow));

		Common common2 = commons.get(1);
		common2.setCreationDate(Date.from(yesterday));


		List<Common> expected = new ArrayList<>();
		expected.add(common2);
		expected.add(common3);
		expected.add(common1);

        ListUtils.sortByCreationDate(commons);

        assertThat(commons.size(), is(3));
        assertThat(commons, is(expected));
    }

	@Test(expected = CustomException.class)
    public void testSortByCreationDateWithNullList() {
        ListUtils.sortByCreationDate(null);
    }

    @Test
    public void testRemoveIfRepeatedIds() {
        Long id = 1L;
		commons.get(1).setId(id);
		commons.get(2).setId(id);

        List<Common> expected = new ArrayList<>();
		expected.add(CommonFactory.getCommonById(id));

        ListUtils.removeIfRepeatedIds(commons);

        assertThat(commons.size(), is(1));
        assertThat(commons, is(expected));
    }

	@Test(expected = CustomException.class)
    public void testRemoveIfRepeatedIdsWithNullList() {
        ListUtils.removeIfRepeatedIds(null);
    }

    @Test
    public void testFindById() {
        Long idToFind = 1L;
        Common expected = ListUtils.findById(idToFind, commons);

		assertThat(CommonFactory.getCommonById(idToFind), is(expected));
    }

    @Test
    public void testFindByIdReturnsNull() {
        Long idToFind = 4L;
        Common expected = ListUtils.findById(idToFind, commons);

        assertThat(expected, is(nullValue()));
    }

	@Test(expected = CustomException.class)
    public void testFindByIdWithNullId() {
        ListUtils.findById(null, commons);
    }

	@Test(expected = CustomException.class)
    public void testFindByIdWithNullList() {
        ListUtils.findById(1L, null);
    }
}
