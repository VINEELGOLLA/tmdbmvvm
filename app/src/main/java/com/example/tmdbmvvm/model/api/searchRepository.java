package com.example.tmdbmvvm.model.api;

import androidx.lifecycle.MutableLiveData;
import com.example.tmdbmvvm.model.pojo.tdmovieresults;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchRepository {

    private static searchRepository searchRepository;

    public static searchRepository getInstance(){
        if(searchRepository == null){
            searchRepository = new searchRepository();
        }
        return searchRepository;
    }

    private tdmovieapi tdmovieapi;

    public searchRepository(){
        tdmovieapi = RetrofitService.createService(tdmovieapi.class);
    }

    public MutableLiveData <tdmovieresults> getNames(String name){
        MutableLiveData<tdmovieresults> names = new MutableLiveData<>();

        tdmovieapi.getlist(name).enqueue(new Callback <tdmovieresults>() {
            @Override
            public void onResponse(Call <tdmovieresults> call,
                                   Response <tdmovieresults> response) {
                if (response.isSuccessful()){
                    names.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<tdmovieresults> call, Throwable t) {
                names.setValue(null);
            }
        });
        return names;
    }
}
