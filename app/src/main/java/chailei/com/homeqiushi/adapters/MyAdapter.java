package chailei.com.homeqiushi.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import chailei.com.homeqiushi.fragments.BlankFragment;

/**
 * Created by Administrator on 15-12-28.
 */
public class MyAdapter extends FragmentPagerAdapter{

    private List<String> list;

    public MyAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (list != null) {
            ret = list.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("Adapter","position"+position);
        return list.get(position);
    }
}
