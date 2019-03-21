package com.demo.configurator.model;

import lombok.Data;

import java.util.Map;

/**
 * Created by jiangtao on 2019-03-20
 */
@Data
public class Package {

    private String name;

    private Boolean def;

    private Map<String, String> features;

    public Package() {
    }

    public Package(String name, Boolean def) {
        this.name = name;
        this.def = def;
    }

}
