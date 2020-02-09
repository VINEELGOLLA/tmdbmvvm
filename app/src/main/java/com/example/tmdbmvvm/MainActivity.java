package com.example.tmdbmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.tmdbmvvm.model.adapter.listadapter;
import com.example.tmdbmvvm.model.adapter.movieAdapter;
import com.example.tmdbmvvm.model.pojo.movieslist;
import com.example.tmdbmvvm.model.pojo.searchname;
import com.example.tmdbmvvm.model.pojo.searchnamemain;
import com.example.tmdbmvvm.model.pojo.tdmovieresults;
import com.example.tmdbmvvm.viewmodels.Main_ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    CharSequence name;
    RecyclerView recyclerView;
    private List <movieslist> data = new ArrayList <>();

    private Main_ViewModel nameviewmodel;


    private movieAdapter adapter;
    private ListView listView;

    private String message = "NO INTERNET";

    private boolean status;

    listadapter listadapter;

    private String sname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        configViews();

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                System.out.println("close listener");
                listView.setVisibility(View.INVISIBLE);
                listView.setEnabled(false);
                listView.setClickable(false);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {


                    System.out.println("onQueryTextSubmit called");
                    name = searchView.getQuery();

                    listView.setVisibility(View.INVISIBLE);
                    listView.setEnabled(false);
                    listView.setClickable(false);
                    searchView.clearFocus();

                    nameviewmodel.search(name.toString());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                /*if(status == true) {
                    System.out.println("onQueryTextChange called");
                    listView.setVisibility(View.VISIBLE);
                    listView.setEnabled(true);
                    listView.setClickable(true);
                    //mController.fetchnames(s);
                }*/

                return false;
            }


        });
        //nameviewmodel = new ViewModelProvider(this).get(Main_ViewModel.class);
        //nameviewmodel =  new ViewModelProvider(this).get(Main_ViewModel.class);
        nameviewmodel = ViewModelProviders.of(MainActivity.this).get(Main_ViewModel.class);
        nameviewmodel.init();


        nameviewmodel.getNewsRepository().observe(MainActivity.this, tdmovieresults -> {
            if(tdmovieresults == null){
                System.out.println("itsnull");
            }
            else {
                System.out.println("itsnulloutside");
                ArrayList <movieslist> newsArticles = tdmovieresults.getResults();
                adapter.addmovies(newsArticles);
            }
        });

    }

    private void configViews() {

        listView = findViewById(R.id.listview);


        searchView = findViewById(R.id.search);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        adapter = new movieAdapter(data,getApplicationContext());

        recyclerView.setAdapter(adapter);
    }
}
