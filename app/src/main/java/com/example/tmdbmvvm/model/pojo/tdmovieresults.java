package com.example.tmdbmvvm.model.pojo;

import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class tdmovieresults {

    private String page;
    private String total_results;
    private String total_pages;
    private ArrayList <movieslist> results;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "tdmovieresults{" +
                "page='" + page + '\'' +
                ", total_results='" + total_results + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", results=" + results +
                '}';
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList <movieslist> getResults() {
        return results;
    }

    public void setResults(ArrayList <movieslist> results) {
        this.results = results;
    }

    public tdmovieresults(String page, String total_results, String total_pages, ArrayList <movieslist> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }
}
