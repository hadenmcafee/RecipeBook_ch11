package hadenmcafee.cidm4385.sp2018.wt.criminalintent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CrimeActivity extends SingleFragmentActivity
{//public class CrimeActivity extends Activity {

    @Override
    protected Fragment createFragment()
    {
        return new CrimeFragment();
    }
}
