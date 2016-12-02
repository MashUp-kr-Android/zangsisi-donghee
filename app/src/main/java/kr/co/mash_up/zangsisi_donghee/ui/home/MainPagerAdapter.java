package kr.co.mash_up.zangsisi_donghee.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import kr.co.mash_up.zangsisi_donghee.ui.comic.ComicListFragment;


public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<ComicListFragment> mFragments;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

    public void addFragment(ComicListFragment fragment) {
        mFragments.add(fragment);
    }
}
