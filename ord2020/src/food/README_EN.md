# Le Petite Chef
(If you want to read this file in a nice format in Eclipse, remember that you can click on the 'Preview' tab in the bottom left of the MD editor).

Le Petite Chef is a small family restaurant. You have been commissioned to create a system for keeping track of recipes, a stock of food (ingredients) and purchases. The chef must, among other things, be able to decide which recipes to use next week (including number of servings), and this can be used when purchasing food.

This exam set is based on extending an existing framework. Most classes already exist. If you need to create some extra things, such as help classes, you are free to do so. If you for any reason want to describe your choices, see the section on Oppgavekommentarer.md below.

## Central Classes

Central to the tasks is the handling of food / ingredients. Eg. both recipes and the food store contain a quantity / number of a set of ingredients. An ingredient is represented by a ** String ** and the amount / number of the ingredient by a decimal (** double **). 


** [Ingredients](Ingredients.java) **

This is an interface with methods for reading and reviewing a set of ingredients and their quantities / numbers and methods related to comparing sets of ingredients. The primary implementation of ** Ingredients ** is ** IngredientsContainer **.



** [IngredientContainer](IngredientContainer.java) **

This class is a concrete implementation of ** Ingredients **, with additional methods for changing (adding and removing) ingredients. This can be used by other classes that need to handle ingredients.

** [Recipe](Recipe.java) and [RecipeReader.java](RecipeReader.java) **

The Recipe class represents a recipe with a set of ingredients for a certain number of servings. Recipes can be loaded from file using the ** RecipeReader ** - class.

** [Kitchen](Kitchen.java) **

The kitchen has an overview of all known recipes and the recipes to be used in the weekly menu. In addition, it has stock of foods, which must be replenished when a new weekly menu is added. The rules for replenishing the stock are described in more detail later.

## Task structure

The Le Petit Chef assignment is divided into 5 tasks, and it is natural to do them in order. You should still think of it as a whole, and it is the end result that needs to be handed in. The classes are already created and contain (some of the required) methods with javadoc and ** // TODO ** comments indicating what needs to be implemented.

Here the steps are outlined, details can be found in [Oppgavebeskrivelse](Oppgavebeskrivelse_EN.md). The links below point to the top of Oppgavebeskrivelse, you need to scroll down to each task.

[Task 1](Oppgavebeskrivelse_EN.md) is about ** IngredientContainer **, which implements ** Ingredients **, ** Recipe ** and ** RecipeReader **.

[Task 2](Oppgavebeskrivelse.md) is about ** Kitchen **. This one includes a set of recipes, a stock of ingredients and next week's menu.

[Task 3](Oppgavebeskrivelse_EN.md) is about delegation, where you need to implement a new method in ** Recipe **

[Task 4](Oppgavebeskrivelse_EN.md) is about observability, where someone should be notified when the chef has finished next week's menu.

[Task 5](Oppgavebeskrivelse_EN.md) is about a JavaFX app where the chef can enter next week's menu.

## Commenting your code
Eclipse's md editor has tabs on the bottom left for writing (** Markdown Source **) and one for viewing the result (** Preview **). If you need to clarify assumptions that you feel you need to make or want to comment on, then you can do so in the md file [Oppgavekommentarer.md](Oppgavekommentarer.md), which we have linked to in the section ** Your comments **. Go to the section of this task that matches the task number you are in.
