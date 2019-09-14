package com.example.nbatabs2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.nbatabs2.R;
import com.example.nbatabs2.TeamDyn;

import static com.example.nbatabs2.TeamBase.CelticsTeam;
import static com.example.nbatabs2.TeamBase.ClippersTeam;
import static com.example.nbatabs2.TeamBase.HawksTeam;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch(position){
            case 0:
                TeamDyn celtics = TeamDyn.newInstance(CelticsTeam);
                return celtics;

            case 1:
                TeamDyn clippers = TeamDyn.newInstance(ClippersTeam);
                return clippers;
            case 2:

                TeamDyn hawks = TeamDyn.newInstance(HawksTeam);
                return hawks;
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}