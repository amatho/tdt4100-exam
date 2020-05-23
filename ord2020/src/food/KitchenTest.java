package food;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class KitchenTest {

	private static final double EPSILON = 0.0001;
	private Kitchen kitchen;
	private List<Recipe> recipes;
	
	private IngredientContainer createIG(Map<String, Double> ingredients) {
		IngredientContainer ig = new IngredientContainer();
		for (String i : ingredients.keySet()) {
			ig.addIngredient(i, ingredients.get(i));
		}
		return ig;
	}

	@Before
	public void setup() {
		recipes = List.of(
				new Recipe(
						"Recipe0",
						"Dinner",
						4,
						createIG(Map.of("food1", 10.0, "food2", 31.0, "food3", 1.0))
						),
				new Recipe(
						"Recipe1",
						"Cocktail",
						4,
						createIG(Map.of("food4", 40.0, "food2", 5.0, "food5", 2.0))
						)
				);
		kitchen = new Kitchen(recipes.toArray(new Recipe[recipes.size()]));
	}

	private void fillKitchen() {
		kitchen.getStorage().addIngredient("food1", 15.0);
		kitchen.getStorage().addIngredient("food2", 31.0);
		kitchen.getStorage().addIngredient("food3", 1.2);
		kitchen.getStorage().addIngredient("food4", 35.1);
		kitchen.getStorage().addIngredient("food5", 5.0);
	}

	@Test
	public void testSetThisWeeksRecipes() {
		kitchen.addRecipeToWeekly(recipes.get(1));
		Collection<Recipe> weeklyRecipes = kitchen.getWeeklyRecipes();
		assertEquals(1, weeklyRecipes.size());
		assertEquals(kitchen.getRecipe("Recipe1"), weeklyRecipes.iterator().next());
	}

	@Test
	public void testCanCreateRecipe() {
		// Add enough food to create recipes[0], but not recipes[1]
		fillKitchen();

		assertTrue(kitchen.canCreateRecipe(recipes.get(0)));
		assertFalse(kitchen.canCreateRecipe(recipes.get(1)));
	}

	@Test
	public void testCreateRecipe() {
		// Add enough food to create recipes[0], but not recipes[1]
		fillKitchen();

		try {
			kitchen.createRecipe(recipes.get(1));
			fail();
		} catch (IllegalArgumentException e) {}

		kitchen.createRecipe(recipes.get(0));
		assertEquals(5.0, kitchen.getStorage().getIngredientAmount("food1"), EPSILON);
		assertEquals(0.0, kitchen.getStorage().getIngredientAmount("food2"), EPSILON);
		assertEquals(0.2, kitchen.getStorage().getIngredientAmount("food3"), EPSILON);
		assertEquals(35.1, kitchen.getStorage().getIngredientAmount("food4"), EPSILON);
		assertEquals(5.0, kitchen.getStorage().getIngredientAmount("food5"), EPSILON);

		Collection<String> expectedNames = Set.of("food1", "food3", "food4", "food5");
		IngredientContainerTest.assertCollectionsContainTheSame(expectedNames, kitchen.getStorage().getIngredientNames());
	}

	@Test
	public void testFilterRecipes() {
		Collection<Recipe> expectedFiltered = Set.of(recipes.get(0));
		Collection<Recipe> actualFiltered = kitchen.filterRecipes(r -> r.getName().equals("Recipe0"));
		IngredientContainerTest.assertCollectionsContainTheSame(expectedFiltered, actualFiltered);
	}

	@Test
	public void testGetRecipesICanCreate() {
		fillKitchen();
		Collection<Recipe> expectedFiltered = Set.of(recipes.get(0));
		Collection<Recipe> actualFiltered = kitchen.getRecipesThatCanBeCreated();
		IngredientContainerTest.assertCollectionsContainTheSame(expectedFiltered, actualFiltered);
	}

	@Test
	public void testGetRecipiesContainingIngredient() {
		fillKitchen();

		Collection<Recipe> expectedFiltered = Set.of(recipes.get(1));
		Collection<Recipe> actualFiltered = kitchen.getRecipiesContainingIngredient("food4");
		IngredientContainerTest.assertCollectionsContainTheSame(expectedFiltered, actualFiltered);
	}
}