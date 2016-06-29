package com.cj.mycollege;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cj.mycollege.announcement.AnnouncementFragment;
import com.cj.mycollege.knownall.KnownAllFragment;
import com.cj.mycollege.notice.NoticeFragment;

/**
 * Created by Eason on 2016/3/31.
 */
//FragmentStatePagerAdapter回收内存，FragmentPagerAdapter不回收内存
public class MyPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitle ={"公告","留言板","百宝箱"};
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AnnouncementFragment();
            case 1:
                return new NoticeFragment();
            case 2:
                return new KnownAllFragment();
        }
        return null;
    }

    public int getCount() {
        return mTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
