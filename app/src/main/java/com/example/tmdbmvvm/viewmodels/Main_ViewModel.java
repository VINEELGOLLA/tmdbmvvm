package com.example.tmdbmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.tmdbmvvm.MainActivity;
import com.example.tmdbmvvm.model.api.searchRepository;
import com.example.tmdbmvvm.model.pojo.searchname;
import com.example.tmdbmvvm.model.pojo.searchnamemain;
import com.example.tmdbmvvm.model.pojo.tdmovieresults;

import java.util.List;

public class Main_ViewModel extends ViewModel {

    private MutableLiveData  <tdmovieresults> mutableLiveData ;
    private searchRepository searchRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        searchRepository = searchRepository.getInstance();
        //mutableLiveData = searchRepository.getNames("");
    }

    public void search(String name){
        //searchRepository = searchRepository.getInstance();
        mutableLiveData = searchRepository.getNames(name);
        //System.out.println(mutableLiveData.getValue().getResults());
    }

    public LiveData <tdmovieresults> getNewsRepository() {
        return mutableLiveData;
    }

}