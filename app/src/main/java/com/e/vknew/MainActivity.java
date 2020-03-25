package com.e.vknew;

import android.os.Bundle;

import com.e.vknew.ui.favourites.FavouritesFragment;
import com.e.vknew.ui.home.FeedFragment;
import com.e.vknew.ui.models.FeedModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Fragment f1 = new Fragment();
    Fragment f2 = new Fragment();
    List<Fragment> list = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        list.add(f1);
        list.add(f2);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_favourites)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);



    }

    public void removeItemLike(FeedModel news) {
        ((FeedFragment)f1   ).removeLike(news);
        ((FavouritesFragment)f2).removeLike(news);
    }
}
