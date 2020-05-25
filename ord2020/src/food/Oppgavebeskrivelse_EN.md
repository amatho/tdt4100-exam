# Le Petite Chef

The five tasks in this part are below.

## Task 1 (25%)

This section is about ** IngredientContainer **, ** Recipe ** and ** RecipeReader **.

** IngredientContainer ** keeps track of the number / quantity of a set of ingredients and is the primary implementation of ** Ingredients **. Since ** Ingredients ** only contains methods for reading information, ** IngredientContainer ** must naturally add methods to change the number / quantity of each ingredient.

** Recipe ** (recipe) represents the ingredients needed for a certain amount of servings of a dish (or drink). The helper class ** RecipeReader ** handles input of recipes from a source, e.g. a file.

** Task **

Implement necessary methods (and fields and auxiliary classes and methods) in

- [IngredientContainer](IngredientContainer.java)
- [Recipe](Recipe.java)
- [RecipeReader](RecipeReader.java)

If you are unable to finish the code reading recipes from file, you can later on use the static method **Recipe.createSampleRecipes()**. This method returns a collection of recipes that you can use in your work. You will find an example of use in [KitchenController.java](KitchenController.java) used in task 5. 

** Your Comments **

Write comments on your solution in [Oppgavekommentarer](Oppgavekommentarer.md).

## Task 2 (15%)

This section is about ** Kitchen ** (without observer, that's done in task 4).

The kitchen has a set of recipes (** Recipe **, as specified in the constructor). Some methods (** getRecipe ** and ** filterRecipes **) handle queries on these.

The kitchen has a food store (** getStorage **), which must be filled with enough food to make the dishes. Therefore, the class has methods focusing on the relationship between recipes and the food store (** canCreateRecipe **, ** getRecipesThatCanBeCreated **, ** getRecipiesContainingIngredient **).

After the restaurant is closed for the week, the chef plans next week's menu (using the methods **addRecipeToWeekly**, **removeRecipeFromWeekly** and **clearWeekly**). This consists of a set of existing recipes and a certain number of portions of them. When all the recipes have been entered, **registerWeekly** is called, where functionality such as creating a shopping list could be envisioned. You do not need to implement functionality for creating such a shopping list, or any other usage of the weekly menu.

** Task **

Implement necessary methods (and fields, methods and helper classes) in

- [Kitchen](Kitchen.java)

** Your Comments **

Write comments on your solution in [Oppgavekommentarer](Oppgavekommentarer.md).

## Task 3 - Delegation (10%)

A *scaled* recipe, like the one returned by ** Recipe ** 's ** createNPortions ** method, can benefit from a separate implementation of ** Ingredients ** implemented using delegation.

** Task **

Implement a scaled recipe using delegation, and use this. You should *not* change the **createNPortions** method you created in Task 1, instead create a new **createNPortionsUsingDelegation** method. Note: You *shall not* use the existing IngredientContainer.scaledIngredients() here. The class delegated to should also implement the scaling.

- [ScaledIngredients](ScaledIngredients.java)
- [Recipe](Recipe.java)

** Your Comments **

Write comments on your solution in [Oppgavekommentarer](Oppgavekommentarer.md).

## Task 4 - Observability (15%)

The restaurant is closed on Sundays, and the chef sits down to create next week's menu:
- The menu for the current week is deleted.
- The chef chooses which dishes to serve and how many portions of each to buy.
- When this job is done, it should be possible for external object to be told. Examples of such objects could be someone responsible for purchases, or an illustrator for the weekly menu.
- You should not implement any of the external listeners, only create code that supports such a pattern.

** Task **

Declare required interfaces and / or classes that support observability and implement required methods (and fields, helper classes and methods) for the behavior described above. Make use of the existing interface [KitchenObserver](KitchenObserver.java).

- [Kitchen](Kitchen.java)
- You should *not* implement a listener here, but your code should support one.

** Your Comments **

Write comments on your solution in [Oppgavekommentarer](Oppgavekommentarer.md).

## Task 5 - JavaFX and FXML (10%)

An app has been created to help the chef plan next week's menu. The file [Kitchen.fxml](Kitchen.fxml) is associated with the Controller class [KitchenController.java](KitchenController.java). The interface contains:

- A drop down menu where all the recipes that are available are entered. You do not need to know much about how this drop-down menu works, in the task you are only asked to read which recipe is selected when a button is pressed.
- A text box where the chef can enter how many portions of the dish can be made next week.
- A button that, when pressed, adds the recipe and the number of servings in next week's menu.
- A text box where all the currently selected dishes are displayed, along with the number of portions of the dish. The content is to be updated by calling the method **updateChosen()**.
- A button that, when pressed, confirms to the system that next week's menu is complete.

You can start the app by running [KitchenApp](KitchenApp.java).

** Task **
- Use the existing code [Kitchen.fxml](Kitchen.fxml) and [KitchenController.java](KitchenController.java)
- Complete the controller to follow the requirements as described above.

** Your Comments **

Write comments on your solution in [Oppgavekommentarer](Oppgavekommentarer.md).


