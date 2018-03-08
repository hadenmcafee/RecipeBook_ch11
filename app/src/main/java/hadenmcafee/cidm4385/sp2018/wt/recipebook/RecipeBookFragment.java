package hadenmcafee.cidm4385.sp2018.wt.recipebook;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecipeBookFragment extends Fragment {
    private RecyclerView mRecipeRecyclerView;
    private RecipeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        mRecipeRecyclerView = (RecyclerView) view
                .findViewById(R.id.recipe_recycler_view);
        mRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        RecipeBook recipeBook = RecipeBook.get(getActivity());
        List<Recipe> recipes = recipeBook.getRecipes();

        if (mAdapter == null) {
            mAdapter = new RecipeAdapter(recipes);
            mRecipeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class RecipeHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Recipe mRecipe;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;
        private ImageView mLasagnaImageView;
        private ImageView mChickenImageView;
        private ImageView mPotRoastImageView;
        private ImageView mYellowImageView;
        private ImageView mPeachImageView;

        public RecipeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_recipe, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.recipe_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.recipe_date);
            mLasagnaImageView = (ImageView) itemView.findViewById(R.id.lasagna_pic);
            mChickenImageView = (ImageView) itemView.findViewById(R.id.chicken_pic);
            mPotRoastImageView = (ImageView) itemView.findViewById(R.id.potroast_pic);
            mYellowImageView = (ImageView) itemView.findViewById(R.id.yellow_pic);
            mPeachImageView = (ImageView) itemView.findViewById(R.id.peach_pic);
        }

        public void bind(Recipe recipe) {
            mRecipe = recipe;
            mTitleTextView.setText(mRecipe.getTitle());
            mDateTextView.setText(mRecipe.getDate().toString());

            if (mTitleTextView.getText() == "Lasagna") {
                mChickenImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPotRoastImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mYellowImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPeachImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
            }

            if (mTitleTextView.getText() == "Chicken Pot Pie") {
                mLasagnaImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPotRoastImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mYellowImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPeachImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
            }

            if (mTitleTextView.getText() == "Pot Roast") {
                mChickenImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mLasagnaImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mYellowImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPeachImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
            }

            if (mTitleTextView.getText() == "Yellow Cake") {
                mChickenImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPotRoastImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mLasagnaImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPeachImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
            }

            if (mTitleTextView.getText() == "Peach Cobbler") {
                mChickenImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mPotRoastImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mYellowImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
                mLasagnaImageView.setVisibility(recipe.isSolved() ? View.VISIBLE : View.GONE);
            }

        }

        @Override
        public void onClick(View view) {
            Intent intent = RecipePagerActivity.newIntent(getActivity(), mRecipe.getId());
            startActivity(intent);
        }
    }

    private class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {

        private List<Recipe> mRecipes;

        public RecipeAdapter(List<Recipe> recipes) {
            mRecipes = recipes;
        }

        @Override
        public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RecipeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RecipeHolder holder, int position) {
            Recipe recipe = mRecipes.get(position);
            holder.bind(recipe);
        }

        @Override
        public int getItemCount() {
            return mRecipes.size();
        }
    }
}
