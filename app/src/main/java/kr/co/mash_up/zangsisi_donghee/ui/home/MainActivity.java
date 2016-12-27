package kr.co.mash_up.zangsisi_donghee.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import kr.co.mash_up.zangsisi_donghee.ui.comic.ComicListFragment;
import kr.co.mash_up.zangsisi_donghee.R;
import kr.co.mash_up.zangsisi_donghee.base.ui.BaseActivity;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.bnv_main)
    BottomNavigationView mBnvMain;

    @BindView(R.id.vp_main)
    ViewPager mVpMain;

    MainPagerAdapter mMainPagerAdapter;

    MenuItem mPreBnvMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        mBnvMain.setOnNavigationItemSelectedListener(this);
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mMainPagerAdapter.addFragment(ComicListFragment.newInstance(getString(R.string.completion)));
        mMainPagerAdapter.addFragment(ComicListFragment.newInstance(getString(R.string.non_completion)));
        mMainPagerAdapter.addFragment(ComicListFragment.newInstance(getString(R.string.search)));
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(mPreBnvMenuItem != null){
                    mPreBnvMenuItem.setChecked(false);
                }
                mPreBnvMenuItem = mBnvMain.getMenu().getItem(position);
                mPreBnvMenuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mPreBnvMenuItem = mBnvMain.getMenu().getItem(0);
        mVpMain.setAdapter(mMainPagerAdapter);
    }

    @Override
    public void initFragment(Fragment fragment) {
        // Do nothing.
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_completion:
                mVpMain.setCurrentItem(0, true);
                return true;
            case R.id.action_non_completion:
                mVpMain.setCurrentItem(1, true);
                return true;
            case R.id.action_search:
                mVpMain.setCurrentItem(2, true);
                return true;
        }
        return false;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
