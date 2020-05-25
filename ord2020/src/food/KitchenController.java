package food;

import java.util.Collection;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class KitchenController {

    @FXML
    private ComboBox<Recipe> recipeSelector;
    private Collection<Recipe> sampleRecipes;

    @FXML
    private TextField portionField;

    @FXML
    private TextArea recipesChosen;

    private Kitchen kitchen;

    @FXML
    private void initialize() {
        this.sampleRecipes = Recipe.createSampleRecipes();
        final Kitchen kitchen = new Kitchen(sampleRecipes.toArray(new Recipe[sampleRecipes.size()]));
        initialize(kitchen);
    }

    /**
     * Kicking off the kitchen. You do not have to modify (or even understand) this method.
     * It fills the ComboBox called recipeSelector with all recipes available in the kitchen.
     * It uses the sample recipes, so as to be available regardless of having implemented
     * reading from file or not.
     *
     * @param kitchen
     */
    public void initialize(Kitchen kitchen) {
        this.kitchen = kitchen;
        recipeSelector.setCellFactory(listView -> createListCell());
        recipeSelector.setButtonCell(createListCell());
        recipeSelector.getItems().addAll(sampleRecipes); // Adds recipes to combobox
        recipeSelector.getSelectionModel().select(0); // Shows the first item

        // Update portion field
        portionField.setText(Integer.toString(recipeSelector.getValue().getNPortions()));
    }

    // helper method
    private ListCell<Recipe> createListCell() {
        return new ListCell<>() {
            @Override
            protected void updateItem(final Recipe recipe, final boolean empty) {
                super.updateItem(recipe, empty);
                setText(empty ? null : recipe.getName() != null ? recipe.getName() : "name not set, check Recipe constructor");
            }
        };
    }

    @FXML
    private void updateSelected() {
        portionField.setText(Integer.toString(recipeSelector.getValue().getNPortions()));
    }

    /**
     * Triggered when user presses button to add recipe to weekly
     */
    @FXML
    private void addRecipeToWeekly() {
        var recipe = recipeSelector.getValue();
        var nPortions = Integer.parseInt(portionField.getText());

        kitchen.addRecipeToWeekly(recipe.createNPortions(nPortions));
        updateChosen();
    }

    /**
     * Triggered when user presses button to state that all recipe for next week are finished.
     */
    @FXML
    private void submitWeeklyRecipes() {
        kitchen.registerWeekly();
        kitchen.clearWeekly();
        recipesChosen.setText("");
    }

    /**
     * Updates the recipesChosen TextField with recipes chosen to be part of next weeks menu. You do not have to modify this method.
     */
    private void updateChosen() {
        final String text = kitchen.getWeeklyRecipes().stream()
                .map(r -> r.getName() + ": " + r.getNPortions())
                .reduce("", (s1, s2) -> s1 + "\n" + s2);
        recipesChosen.setText(text);
    }
}
