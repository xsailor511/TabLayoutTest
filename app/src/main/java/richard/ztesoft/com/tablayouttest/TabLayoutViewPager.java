package richard.ztesoft.com.tablayouttest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import richard.ztesoft.com.tablayouttest.fragment.Fragment0;
import richard.ztesoft.com.tablayouttest.fragment.Fragment1;
import richard.ztesoft.com.tablayouttest.fragment.Fragment2;

public class TabLayoutViewPager extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Fragment0 fragment0;
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    private List<Fragment> listFragments;
    private List<String> list_title;
    private FragmentViewPagerAdapter fragmentViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_view_pager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        fragment0 = new Fragment0();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        listFragments = new ArrayList<>();
        list_title = new ArrayList<>();

        listFragments.add(fragment0);
        listFragments.add(fragment1);
        listFragments.add(fragment2);

        list_title.add("fragment0");
        list_title.add("fragment1");
        list_title.add("fragment2");

        fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        fragmentViewPagerAdapter.setList_fragment(listFragments);
        fragmentViewPagerAdapter.setList_Title(list_title);

        viewPager.setAdapter(fragmentViewPagerAdapter);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(2)));

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
