package com.example.tmdbmvvm.model.pojo;

import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.List;

public class searchnamemain implements Serializable {
    private String page;
    private MutableLiveData <searchname> results;

    public searchnamemain(String page, MutableLiveData <searchname> results) {
        this.page = page;
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "searchnamemain{" +
                "page='" + page + '\'' +
                ", results=" + results +
                '}';
    }

    public void setPage(String page) {
        this.page = page;
    }

    public MutableLiveData <searchname> getResults() {
        return results;
    }

    public void setResults(MutableLiveData <searchname> results) {
        this.results = results;
    }
}
