package hadenmcafee.cidm4385.sp2018.wt.recipebook;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static android.widget.CompoundButton.*;

public class RecipeFragment extends Fragment {
    private static RecipeFragment sCrimeLab;





    private static final String ARG_RECIPE_ID = "recipe_id";

    private List<Recipe> mIngredient;
    private Recipe mRecipe;
    private EditText mTitleField;
    private TextView mIng1;
    private TextView mIng2;
    private TextView mIng3;
    private TextView mIng4;
    private TextView mIng5;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;

    public static RecipeFragment newInstance(UUID recipeID) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_RECIPE_ID, recipeID);

        RecipeFragment fragment = new RecipeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID recipeId = (UUID) getArguments().getSerializable(ARG_RECIPE_ID);
        mRecipe = RecipeBook.get(getActivity()).getRecipe(recipeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recipe, container, false);
        final String[] mobileArray = {"Lasagna Noodles", "Ground Beef", "Marinara Sauce", "Ricotta Cheese", "Mozzarella Shredded Cheese"};

        mTitleField = (EditText) v.findViewById(R.id.recipe_title);
        mTitleField.setText(mRecipe.getTitle());

        mIng1 = (TextView) v.findViewById(R.id.ing_jedna);
        mIng1.setText(mRecipe.getIng1());

        mIng2 = (TextView) v.findViewById(R.id.ing_dva);
        mIng2.setText(mRecipe.getIng2());

        mIng3 = (TextView) v.findViewById(R.id.ing_tri);
        mIng3.setText(mRecipe.getIng3());

        mIng4 = (TextView) v.findViewById(R.id.ing_ctyri);
        mIng4.setText(mRecipe.getIng4());

        mIng5 = (TextView) v.findViewById(R.id.ing_pet);
        mIng5.setText(mRecipe.getIng5());



        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecipe.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.recipe_completed);
        mSolvedCheckbox.setChecked(mRecipe.isSolved());
        mSolvedCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                mRecipe.setSolved(isChecked);
            }
        });

        return v;
    }
}

