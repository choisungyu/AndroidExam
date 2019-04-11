package com.csg.androidexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieFragment movieFragment = MovieFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, movieFragment)
                .commit();

    }
}
