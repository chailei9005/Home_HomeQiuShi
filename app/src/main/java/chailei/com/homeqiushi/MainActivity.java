package chailei.com.homeqiushi;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import chailei.com.homeqiushi.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private NavigationView menu;

    private TabLayout tabLayout;

    private int count;
    private ViewPager pager;
    private MyAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("糗事百科");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw);
        menu = (NavigationView) findViewById(R.id.menu);
        pager = (ViewPager) findViewById(R.id.view_pager);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        list = new ArrayList<String>();
//        list.add("糗事");
//        list.add("糗友圈");
//        list.add("发现");
//        list.add("小字条");
//        list.add("设置");
//        list.add("自己");
        //专享  视频  纯文  纯图  精华  最新
        list.add("专享");
        list.add("视频");
        list.add("纯文");
        list.add("纯图");
        list.add("精华");
        list.add("最新");
        adapter = new MyAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        menu.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,0,0);
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);
        tabLayout.setOnTabSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        switch (itemId){
            case R.id.item1:
                count = 0;
                list.clear();
                list.add("专享");
                list.add("视频");
                list.add("纯文");
                list.add("纯图");
                list.add("精华");
                list.add("最新");
                Log.d("qiushi","糗事");
                break;
            case R.id.item2:
                count = 1;
                list.clear();
                list.add("已加好友");
                list.add("附加好友");
                Log.d("qiushi","糗友圈");
                break;
            case R.id.item3:
                count = 2;
                list.clear();
                list.add("淘宝");
                list.add("京东");
                Log.d("qiushi","发现");
                break;
            case R.id.item4:
                count = 3;
                list.clear();
                list.add("大美女");
                list.add("小美女");
                Log.d("qiushi","小字条");
                break;
            case R.id.settings:
                count = 4;
                Log.d("qiushi","设置");
                break;
            case R.id.self:
                count = 5;
                Log.d("qiushi","自己");
                break;
            case R.id.quit:
                ActivityCompat.finishAffinity(this);
                break;
        }

        adapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(pager);
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
