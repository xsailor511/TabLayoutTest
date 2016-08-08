package richard.ztesoft.com.tablayouttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by richard on 16/7/28.
 */
public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;                         //fragment列表
    private List<String> list_Title;                              //tab名的列表

    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setList_fragment(List<Fragment> list_fragment) {
        this.list_fragment = list_fragment;
    }

    public void setList_Title(List<String> list_Title) {
        this.list_Title = list_Title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment == null ? 0 : list_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position % list_Title.size());
    }
}
