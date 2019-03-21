package com.demo.configurator.model;

import lombok.Data;

import java.util.List;

/**
 * Created by jiangtao on 2019-03-20
 */
@Data
public class Feature {

    private String name;

    private String description;

    public Feature() {
    }

    public Feature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private List<FeatureOption> options;
}
