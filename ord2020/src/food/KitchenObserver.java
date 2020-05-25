package food;

import java.util.List;

public interface KitchenObserver {
    void weeklyRecipeAdded(Recipe recipe);
    void weeklyRecipeRemoved(Recipe recipe);

    void weeklyRecipesRegistered(List<Recipe> recipes);
}
