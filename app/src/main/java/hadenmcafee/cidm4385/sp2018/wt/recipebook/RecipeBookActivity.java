package hadenmcafee.cidm4385.sp2018.wt.recipebook;

import android.support.v4.app.Fragment;

public class RecipeBookActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new RecipeBookFragment();
    }
}