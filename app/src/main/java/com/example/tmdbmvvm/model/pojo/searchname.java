package com.example.tmdbmvvm.model.pojo;

import java.io.Serializable;

public class searchname implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "searchname{" +
                "name='" + name + '\'' +
                '}';
    }

    public searchname(String name) {
        this.name = name;
    }
}
