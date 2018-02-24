package hadenmcafee.cidm4385.sp2018.wt.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Haden McAfee on 2/18/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new CrimeListFragment();
    }
}
