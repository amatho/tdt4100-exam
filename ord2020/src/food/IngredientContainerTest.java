package food;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class IngredientContainerTest {
	private static final double EPSILON = 0.0001;

	private IngredientContainer createDefaultContainer() {
		IngredientContainer ig = new IngredientContainer();
		ig.addIngredient("food1", 5.0);
		ig.addIngredient("food2", 10.0);
		ig.addIngredient("food3", 15.0);
		return ig;
	}

	public static <T> void assertCollectionsContainTheSame(Collection<T> expected, Collection<T> actual) {
		assertTrue(actual + " differs from " + expected, expected.containsAll(actual) && actual.containsAll(expected));
	}

	@Test
	public void testAddIngredient() {
		IngredientContainer container = new IngredientContainer();
		container.addIngredient("food1", 12.0);
		container.addIngredient("food2", 6.0);

		assertEquals(12.0, container.getIngredientAmount("food1"), EPSILON);
		assertEquals(6.0, container.getIngredientAmount("food2"), EPSILON);

		Collection<String> names = container.getIngredientNames();
		Collection<String> expectedNames = Set.of("food1", "food2");

		assertCollectionsContainTheSame(expectedNames, names);

		container.addIngredient("food1", 5.2);

		assertEquals(17.2, container.getIngredientAmount("food1"), EPSILON);
		assertEquals(6.0, container.getIngredientAmount("food2"), EPSILON);

		names = container.getIngredientNames();
		assertCollectionsContainTheSame(expectedNames, names);
	}

	@Test
	public void testRemoveIngredient() {
		IngredientContainer container = createDefaultContainer();

		container.removeIngredient("food1", 3.0);
		assertEquals(2.0, container.getIngredientAmount("food1"), EPSILON);
		assertEquals(10.0, container.getIngredientAmount("food2"), EPSILON);
		assertEquals(15.0, container.getIngredientAmount("food3"), EPSILON);
		Collection<String> expectedNames = Set.of("food1", "food2", "food3");
		assertCollectionsContainTheSame(expectedNames, container.getIngredientNames());

		container.removeIngredient("food2", 10.0);
		assertEquals(2.0, container.getIngredientAmount("food1"), EPSILON);
		assertEquals(0.0, container.getIngredientAmount("food2"), EPSILON);
		assertEquals(15.0, container.getIngredientAmount("food3"), EPSILON);
		expectedNames = Set.of("food1", "food3"); // The ingredient should be removed from the container when no more is left
		assertCollectionsContainTheSame(expectedNames, container.getIngredientNames());
	}

	@Test
	public void testGetIngredientNames() {
		IngredientContainer container = createDefaultContainer();

		Collection<String> expectedNames = Set.of("food1", "food2", "food3");
		assertCollectionsContainTheSame(expectedNames, container.getIngredientNames());
	}

	@Test
	public void testGetIngredientAmount() {
		IngredientContainer container = createDefaultContainer();

		assertEquals(5.0, container.getIngredientAmount("food1"), EPSILON);
		assertEquals(10.0, container.getIngredientAmount("food2"), EPSILON);
		assertEquals(15.0, container.getIngredientAmount("food3"), EPSILON);
	}

	@Test
	public void testListIngredients() {
		IngredientContainer container = createDefaultContainer();

		Collection<String> expectedLines = new TreeSet<>(Arrays.asList("food1: 5.0", "food2: 10.0", "food3: 15.0"));
		Collection<String> actualLines = new TreeSet<>(Arrays.asList(container.toString().split("\n")));

		assertCollectionsContainTheSame(expectedLines, actualLines);
	}
}