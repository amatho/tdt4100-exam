package food;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Generic container of ingredients.
 */
public class IngredientContainer implements Ingredients {

    private final HashMap<String, Double> ingredients;

    /**
     * Initializes a new, empty IngredientContainer.
     */
    public IngredientContainer() {
        ingredients = new HashMap<>();
    }

    /**
     * Initializes a new IngredientContainer.
     * @param ingredients Initial ingredients in the container
     */
    public IngredientContainer(Ingredients ingredients) {
        this.ingredients = new HashMap<>();

        for (var name : ingredients.ingredientNames()) {
            var amount = ingredients.getIngredientAmount(name);
            this.ingredients.put(name, amount);
        }
    }

    /**
     * Add `amount` of `ingredient` to the container.
     *
     * @param ingredient The name of the ingredient to add
     * @param amount The amount of the ingredient to add
     * @throws IllegalArgumentException if amount is not positive
     */
    public void addIngredient(String ingredient, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        ingredients.merge(ingredient, amount, Double::sum);
    }

    /**
     * Remove `amount` of `ingredient` to the container.
     *
     * If the resulting amount of the ingredient is 0, its name should be removed
     *
     * @param ingredient The name of the ingredient to add
     * @param amount The amount of the ingredient to remove
     * @throws IllegalArgumentException if amount cannot be removed from this
     */
    public void removeIngredient(String ingredient, double amount) {
        var newAmount = ingredients.computeIfPresent(ingredient, (key, existing) -> existing - amount);

        if (newAmount == null) {
            throw new IllegalArgumentException("Key does not exist");
        } else if (newAmount <= 0) {
            ingredients.remove(ingredient);
        }
    }

    /**
     * @return An Iterable giving the names of all the ingredients
     */
    @Override
    public Iterable<String> ingredientNames() {
        return ingredients.keySet();
    }

    /**
     * @return A collection containing the names of all the ingredients
     */
    @Override
    public Collection<String> getIngredientNames() {
        return ingredients.keySet();
    }

    /**
     * @param ingredient The ingredient to get the amount of
     * If the ingredient does not exist, the double 0.0 should be returned.
     * @return The amount of ingredient
     */
    @Override
    public double getIngredientAmount(String ingredient) {
        return ingredients.getOrDefault(ingredient, 0d);
    }

    /**
     * Get a string containing the ingredients with amounts in the format given below:
     * Mark that it does not matter in which order the ingredients are listed.
     *
     * ingredientName1: amount1
     * ingredientName2: amount2
     * ingredientName3: amount3
     * ...
     *
     * @return A string on the format given above
     */
    @Override
    public String toString() {
        var strings = new ArrayList<String>();
        for (var entry : ingredients.entrySet()) {
            strings.add(entry.getKey() + ": " + entry.getValue());
        }

        return String.join("\n", strings);
    }

    /**
     * Add all ingredients from another Ingredients object into this.
     *
     * @param ingredients the ingredients to add
     */
    public void addIngredients(Ingredients ingredients) {
        for (var name : ingredients.ingredientNames()) {
            var amount = ingredients.getIngredientAmount(name);
            this.ingredients.merge(name, amount, Double::sum);
        }
    }

    /**
     * Remove all ingredients in other from this.
     *
     * @param ingredients the ingredients to remove
     * @throws IllegalArgumentException if this does not contain enough of any of the ingredients (without changing this)
     */
    public void removeIngredients(Ingredients ingredients) {
        if (!containsIngredients(ingredients)) {
            throw new IllegalArgumentException("Not enough of any of the ingredients");
        }

        for (var name : ingredients.ingredientNames()) {
            var amount = ingredients.getIngredientAmount(name);
            var existing = this.ingredients.get(name);
            var newAmount = existing - amount;
            if (newAmount <= 0) {
                this.ingredients.remove(name);
            } else {
                this.ingredients.replace(name, newAmount);
            }
        }
    }

    /**
     * Checks if the all the ingredients in other is contained in this
     * @param other
     * @return true of there is at least the same or larger amount of ingredients in this than in other, false otherwise
     */
    @Override
    public boolean containsIngredients(Ingredients other) {
        for (var name : other.ingredientNames()) {
            var amount = other.getIngredientAmount(name);
            if (this.ingredients.getOrDefault(name, 0d) < amount) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the ingredients that must be added to other for this to be contained in it
     * @param other
     * @return a new Ingredients that if added to other would make it contain this
     */
    @Override
    public Ingredients missingIngredients(Ingredients other) {
        var missing = new IngredientContainer();
        var otherNames = other.getIngredientNames();

        for (var entry : ingredients.entrySet()) {
            var name = entry.getKey();
            var amount = entry.getValue();
            var otherAmount = other.getIngredientAmount(name);
            if (!otherNames.contains(name)) {
                missing.addIngredient(name, amount);
            } else if (otherAmount < amount) {
                missing.addIngredient(name, amount - otherAmount);
            }
        }

        return missing;
    }

    /**
     * Returns the ingredients that you get if you scale this by factor 'scale'.
     * I.e. an IngredientContainer with 4 portions scaled by 2 ends up with 8 portions.
     * See example in main method.
     * @param scale
     * @return a new scaled Ingredients
     */
    @Override
    public Ingredients scaleIngredients(double scale) {
        var scaled = new IngredientContainer();

        for (var entry : ingredients.entrySet()) {
            scaled.ingredients.put(entry.getKey(), entry.getValue() * scale);
        }

        return scaled;
    }


    /**
     * Some helpful code to debug your code. Does not cover everything!
     * @param args
     */
    public static void main(String[] args) {

        final IngredientContainer container = new IngredientContainer();
        container.addIngredient("food1", 12.0);
        container.addIngredient("food2", 6.0);
        container.addIngredient("food2", 2.5);

        // food2 should now be 8.5, with a small delta added for double rounding.
        assertEquals(8.5, container.getIngredientAmount("food2"), 0.0001);
        System.out.println(container);

        // Double the ingredients:
        Ingredients twice = container.scaleIngredients(2);
        assertEquals(17.0, twice.getIngredientAmount("food2"), 0.0001);

        // Remove food from the first container:
        container.removeIngredient("food1", 10);
        System.out.println(container);
        assertEquals(2.0, container.getIngredientAmount("food1"), 0.0001);


    }
}
