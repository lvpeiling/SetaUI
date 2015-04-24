package com.gxu.administrator.navigationfinally;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{
    private DrawerLayout mDrawerLayout;
    private ListView leftDrawerList;
    private ListView rightDrawerList;
    private ArrayList<String> menuList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        leftDrawerList=(ListView)findViewById(R.id.left_drawer);
        menuList=new ArrayList<String>();
        menuList.add("首页");
        menuList.add("账户管理");
        menuList.add("文件管理");
        menuList.add("收藏");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menuList);
        leftDrawerList.setAdapter(adapter);
        leftDrawerList.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //动态插入一个fragment到FrameLayout中

//        Bundle args=new Bundle();
//        args.putString("text",menuList.get(position));
//        mFragment.setArguments(args);
        switch (position){
            case 0:{
                Fragment mFragment=new mainFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,mFragment).commit();
                mDrawerLayout.closeDrawer(leftDrawerList);
                break;
            }
            case 1:
            {
                Fragment mFragment=new firstFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,mFragment).commit();
                mDrawerLayout.closeDrawer(leftDrawerList);
            }

        }
//        FragmentManager fragmentManager=getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_frame,mFragment).commit();
//        mDrawerLayout.closeDrawer(mDrawerList);
        }

}

