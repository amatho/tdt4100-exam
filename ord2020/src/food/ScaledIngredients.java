package food;

public class ScaledIngredients implements Ingredients {

	// TODO: necessary declarations

	/**
	 * Create a new scaled ingredients, given by an original `Ingredients`-object and a scale
	 * @param ingredients The ingredients to be scaled
	 * @param scale The scale to use
	 */
	public ScaledIngredients(Ingredients ingredients, double scale) {
		// TODO
	}

	
	// TODO: necessary methods
	
	
	
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
