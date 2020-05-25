package food;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeReader {

    // regex for column separator
    private final String columnSeparatorRegex = "\\$";
    private final String elementSeparatorRegex = ";";

    /**
     * Read recipes from an InputStream with the given format:
     *
     * name$category$nPortions$ingredient1;ingredient2;...;...$amount1;amount2;...;...
     *
     * As you see from the format, each recipe is a single line, with fields separated by `$` and
     * elements in lists separated by `;`.
     *
     * Regarding ingredients and amounts, the two lists are sorted in the same order, so `ingredient1`
     * should have `amount1`, and so forth. All amounts can be read as doubles, while nPortions is an integer.
     *
     * Note that the first line of the stream is the header, and so should not be used.
     * If a line (i.e. a single recipe) fails to be parsed correctly, that recipe is to be skipped.
     *
     * @param input The source to read from
     * @throws IOException if input (InputStream) throws IOException
     */
    public List<Recipe> readRecipes(InputStream input) throws IOException {
        var recipes = new ArrayList<Recipe>();
        var in = new BufferedReader(new InputStreamReader(input));

        try {
            var iter = in.lines().iterator();
            iter.next();

            while (iter.hasNext()) {
                var line = iter.next();
                var segments = line.split(columnSeparatorRegex);
                if (segments.length != 5) {
                    continue;
                }

                var name = segments[0];
                var category = segments[1];
                Integer nPortions;
                try {
                    nPortions = Integer.parseInt(segments[2]);
                } catch (NumberFormatException e) {
                    continue;
                }

                var ingredientNames = segments[3].split(elementSeparatorRegex);
                List<Double> amounts;
                try {
                    amounts = Arrays.stream(segments[4].split(elementSeparatorRegex)).map(Double::parseDouble).collect(Collectors.toList());
                } catch (NumberFormatException | NullPointerException e) {
                    continue;
                }

                var ingredients = new IngredientContainer();
                for (var i = 0; i < ingredientNames.length; i++) {
                    ingredients.addIngredient(ingredientNames[i], amounts.get(i));
                }
                recipes.add(new Recipe(name, category, nPortions, ingredients));
            }
        } finally {
            in.close();
        }

        return recipes;
    }

    public static void main(String[] args) throws IOException {
        // read from sample file
        List<Recipe> recipes = new RecipeReader().readRecipes(RecipeReader.class.getResourceAsStream("sample-recipes.txt"));
        System.out.println(recipes);
    }
}
