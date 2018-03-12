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

    //List out every possible recipe
    private RecipeBook(Context context) {
        mRecipes = new ArrayList<>();
        //String [] Recipe = {"Lasagna", "Chicken Pot Pie", "Pot Roast", "Yellow Cake", "Peach Cobbler"};
        for (int i = 0; i < 5; i++) {
            Recipe recipe = new Recipe();
            if(i==0){
                recipe.setTitle("Lasagna");
                recipe.setIng1("Pasta");
                recipe.setIng2("Tomato sauce");
                recipe.setIng3("Cheese");
                recipe.setIng4("beef");
                recipe.setIng5("Butter");
                recipe.setProcess("1.Preheat oven\n2.cook beef \n3.layer pasta, cheese, beef and sauce \n4.bake for 20 min ");

            }else if(i==1){
                recipe.setTitle("Chicken Pot Pie");
                recipe.setIng1("Chicken");
                recipe.setIng2("Carrots");
                recipe.setIng3("Peas");
                recipe.setIng4("Celery");
                recipe.setIng5("Pie Crust");
                recipe.setProcess("1.Pre-heat oven\n2.cook the ingredients \n3.crust-filling-crust \n4.bake for 20 min ");

            }else if(i==2){
                recipe.setTitle("Pot Roast");
                recipe.setIng1("Chuck Steak");
                recipe.setIng2("Olive oil");
                recipe.setIng3("Onion");
                recipe.setIng4("Carrots");
                recipe.setIng5("Salt");
                recipe.setProcess("1.Cut the veggies and meat into small pieces \n2.Cook it for 45-60 min \n3.serve  ");

            }else if(i==3){
                recipe.setTitle("Yellow Cake");
                recipe.setIng1("Flour");
                recipe.setIng2("baking powder");
                recipe.setIng3("Sugar");
                recipe.setIng4("Butter");
                recipe.setIng5("Vanilla");
                recipe.setProcess("1.Mix the ingredients in a large bowl with mild \n2.pour into oiled dish \n3.bake for 48 min ");

            }else if(i==4){
                recipe.setTitle("Peach Cobbler");
                recipe.setIng1("Salt");
                recipe.setIng2("Baking Powder");
                recipe.setIng3("Sugar");
                recipe.setIng4("Flour");
                recipe.setIng5("Butter");
                recipe.setProcess("1.Melt butter and put it in a dish \n2.put together & stir the ingredients \n3.dough-peaches-dough \n4.bake for 30 min");

            }
            //recipe.setTitle(Recipe[i] + " Recipe");
            //recipe.setSolved(i % 2 == 0);
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