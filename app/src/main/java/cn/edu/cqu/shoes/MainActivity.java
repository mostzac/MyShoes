package cn.edu.cqu.shoes;

import Values.*;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import cn.edu.cqu.shoes.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private String TAG = MainActivity.class.getSimpleName();

    private fragment_shoes_list mshoeslistFragment;
    private fragment_add_report maddreportFragment;
    private fragment_user muserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_location_on_white_24dp, "shoeslist").setActiveColor(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.mipmap.ic_find_replace_white_24dp, "addreport").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.ic_favorite_white_24dp, "user").setActiveColor(R.color.colorPrimaryDark))
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setFirstSelectedPosition(lastSelectedPosition )
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mshoeslistFragment = fragment_shoes_list.newInstance("shoeslist");
        transaction.add(R.id.fragment_layout, mshoeslistFragment);
        //transaction.show(mshoeslistFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
        lastSelectedPosition = position;
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mshoeslistFragment == null) {
                    mshoeslistFragment = mshoeslistFragment.newInstance("shoeslist");
                }
                transaction.replace(R.id.fragment_layout, mshoeslistFragment);
                break;
            case 1:
                if (maddreportFragment == null) {
                    maddreportFragment = maddreportFragment.newInstance("addreport");
                }
                transaction.replace(R.id.fragment_layout, maddreportFragment);
                break;
            case 2:
                if (muserFragment == null) {
                    muserFragment = muserFragment.newInstance("user");
                }
                transaction.replace(R.id.fragment_layout, muserFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {
        Log.d(TAG, "onTabUnselected() called with: " + "position = [" + position + "]");
    }

    @Override
    public void onTabReselected(int position) {

    }

}
