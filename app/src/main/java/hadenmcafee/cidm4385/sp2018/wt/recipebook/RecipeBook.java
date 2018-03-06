package hadenmcafee.cidm4385.sp2018.wt.recipebook;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecipeBook {
    private static RecipeBook sRecipeBook;

    private List<Recipe> mRecipes;

    public static RecipeBook get(Context context) {
        if (sRecipeBook == null) {
            sRecipeBook = new RecipeBook(context);
        }

        return sRecipeBook;
    }

    private RecipeBook(Context context) {
        mRecipes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Recipe recipe = new Recipe();
            recipe.setTitle("Recipe #" + i);
            recipe.setSolved(i % 2 == 0);
            mRecipes.add(recipe);
        }
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }

    public Recipe getRecipe(UUID id) {
        for (Recipe recipe : mRecipes) {
            if (recipe.getId().equals(id)) {
                return recipe;
            }
        }

        return null;
    }
}
