package com.demo.configurator.model;

import lombok.Data;

import java.util.List;

/**
 * Created by jiangtao on 2019-03-20
 */
@Data
public class Model {

    private String name;

    public Model() {
    }

    public Model(String name) {
        this.name = name;
    }

    private List<Feature> features;

    private List<Package> packages;
}
