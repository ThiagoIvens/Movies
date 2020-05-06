package com.thiagoivens.movies;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.thiagoivens.movies.Actor.ActorFragment;
import com.thiagoivens.movies.Director.DirectorFragment;
import com.thiagoivens.movies.Movie.MovieFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adicionar os fragmentos aqui
        adapter.AddFragment(new DirectorFragment(), "");
        adapter.AddFragment(new ActorFragment(), "");
        adapter.AddFragment(new MovieFragment(), "");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //Adiciona os icones ao tabView
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_local_movies);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_person);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_supervisor_account);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
