package food;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class RecipeTest {
	private static final double EPSILON = 0.0001;
	
	private IngredientContainer createIG(Map<String, Double> ingredients) {
		IngredientContainer ig = new IngredientContainer();
		for (String i : ingredients.keySet()) {
			ig.addIngredient(i, ingredients.get(i));
		}
		return ig;
	}

	@Test
	public void testCreateNPortions() {
		Recipe r = new Recipe(
				"Recipe",
				"Dinner",
				4,
				createIG(Map.of("food1", 10.0, "food2", 31.0, "food3", 2.0))
				);

		Recipe r2 = r.createNPortions(8);
		assertEquals(20.0, r2.getIngredients().getIngredientAmount("food1"), EPSILON);
		assertEquals(62.0, r2.getIngredients().getIngredientAmount("food2"), EPSILON);
		assertEquals(4.0, r2.getIngredients().getIngredientAmount("food3"), EPSILON);
		Collection<String> expectedNames = Set.of("food1", "food2", "food3");
		IngredientContainerTest.assertCollectionsContainTheSame(expectedNames, r2.getIngredients().getIngredientNames());

		Recipe r3 = r.createNPortions(2);
		assertEquals(5.0, r3.getIngredients().getIngredientAmount("food1"), EPSILON);
		assertEquals(15.5, r3.getIngredients().getIngredientAmount("food2"), EPSILON);
		assertEquals(1.0, r3.getIngredients().getIngredientAmount("food3"), EPSILON);
		Collection<String> expectedNames2 = Set.of("food1", "food2", "food3");
		IngredientContainerTest.assertCollectionsContainTheSame(expectedNames2, r3.getIngredients().getIngredientNames());
	}
}