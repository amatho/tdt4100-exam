package food;

import java.util.Collection;

public class ScaledIngredients implements Ingredients {

	private final IngredientContainer ingredients;

	/**
	 * Create a new scaled ingredients, given by an original `Ingredients`-object and a scale
	 * @param ingredients The ingredients to be scaled
	 * @param scale The scale to use
	 */
	public ScaledIngredients(Ingredients ingredients, double scale) {
		this.ingredients = new IngredientContainer();

		for (var name : ingredients.getIngredientNames()) {
			var amount = ingredients.getIngredientAmount(name);
			this.ingredients.addIngredient(name, amount * scale);
		}
	}

	@Override
	public Iterable<String> ingredientNames() {
		return ingredients.ingredientNames();
	}

	@Override
	public Collection<String> getIngredientNames() {
		return ingredients.getIngredientNames();
	}

	@Override
	public double getIngredientAmount(String ingredient) {
		return ingredients.getIngredientAmount(ingredient);
	}

	@Override
	public boolean containsIngredients(Ingredients other) {
		return ingredients.containsIngredients(other);
	}

	@Override
	public Ingredients missingIngredients(Ingredients other) {
		return ingredients.missingIngredients(other);
	}

	@Override
	public Ingredients scaleIngredients(double scale) {
		return new ScaledIngredients(this, scale);
	}

	// Examples of SOME use of ScaledIngredients.
	public static void main(String[] args) {

		// ingredients in a recipe could be..
		IngredientContainer ig = new IngredientContainer();
		ig.addIngredient("egg", 4);
		ig.addIngredient("milk", 5);
		ig.addIngredient("flour", 3);
		ig.addIngredient("salt", 1);

		// Scaling IngredientContainer to double the size.
		ScaledIngredients scaledIngredients = new ScaledIngredients(ig, 2); 

		// Should have 8 eggs:
		System.out.println("Eggs: " + scaledIngredients.getIngredientAmount("egg"));

		// Storage contains...
		IngredientContainer storage = new IngredientContainer();
		storage.addIngredient("egg", 3);
		storage.addIngredient("milk", 3);
		storage.addIngredient("flour", 3);
		storage.addIngredient("salt",3);
		
		// Storage should miss 5.0 egg, 3.0 flour and 7.0 milk.
		System.out.println(scaledIngredients.missingIngredients(storage));

		// Should be [salt, egg, flour, milk] (In some order)
		System.out.println(scaledIngredients.getIngredientNames());
		
		// Add more salt to original container
		ig.addIngredient("salt", 3);
		
		// Should now have 8 salt
		System.out.println("Salt: " + scaledIngredients.getIngredientAmount("salt"));
	}
}
