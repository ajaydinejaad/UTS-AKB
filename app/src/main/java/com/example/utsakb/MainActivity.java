package com.example.utsakb;
/* 10118707 , R Wiranda Purba , IF 10
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    BottomNavigationView bottomNavigationView;
    private NavigationBarView.OnItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()) {
                case R.id.menu_profil:
                    f = new FragmentProfil();
                    break;
                case R.id.menu_list:
                    f = new FragmentList();
                    break;
                case R.id.menu_informasi:
                    f = new FragmentInformasi();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, f).commit();
            return true;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnItemSelectedListener(navigation);

        /*adapter ke viewpager*/
        setupViewPager();
    }

    private void setupViewPager() {
        adapter = new Adapter(this);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

    }


    private class Adapter extends PagerAdapter {
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
        }

        // list img
        int[] list_img ={
            R.drawable.flyhigh,
            R.drawable.flyhigh,
            R.drawable.flyhigh
        };

        // list judul
        int[] list_judul = {
                R.string.judul_1,
                R.string.judul_2,
                R.string.judul_3
        };

        //list deskripsi
        int[] list_deskripsi = {
                R.string.desk_1,
                R.string.desk_2,
                R.string.desk_3
        };

        //list color bg
        int[] list_bg = {
                getResources().getColor(R.color.red),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.green)
        };


        @Override
        public int getCount() {

            return list_judul.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return (view == object);
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_layout, container, false);
            LinearLayout linearLayout = view.findViewById(R.id.item_layout);
            ImageView imageView = view.findViewById(R.id.img);
            TextView judul = view.findViewById(R.id.judul);
            TextView desk = view.findViewById(R.id.deskripsi);

            linearLayout.setBackgroundColor(list_bg[position]);
            imageView.setImageResource(list_img[position]);
            judul.setText(list_judul[position]);
            desk.setText(list_deskripsi[position]);
            container.addView(view);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }
    }
}