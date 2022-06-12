package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainPage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private long id;
    private String username, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            id = extras.getLong(LoginActivity.USER_ID);
            if (id == 0) {
                id = extras.getLong(String.valueOf(WelcomeActivity.USER_ID));
            }
            Log.d("error", " " + id);
            User user = MovieDatabase.getInstance(this).userDao().getUserById(id);
            username = user.getUsername();
            email = user.getEmail();
        }

        bottomNavigationView=findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        viewPager=findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUpAdapter(viewPager);
    }
    private void setUpAdapter(ViewPager viewPager){
        FragmentAdapter viewPageAdapter= new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(new MovieFragment(id));
        viewPageAdapter.addFragment(new ReservationFragment(id));
        viewPageAdapter.addFragment(new ProfileFragment(username, email, id));
        viewPager.setAdapter(viewPageAdapter);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("DEBUG","Item clicked "+item.getItemId());
            switch (item.getItemId()){
                case R.id.nav_movie:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_reservation:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_profile:
                    viewPager.setCurrentItem(2);
                    return true;
                default:
                    return false;
            }
        }
    };

    public void onLogoutClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}