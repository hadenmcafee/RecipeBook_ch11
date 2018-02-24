package hadenmcafee.cidm4385.sp2018.wt.criminalintent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Haden McAfee on 2/18/2018.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity
{
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //get fragment manager, set fragment
        FragmentManager fm = getSupportFragmentManager();//getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
