package com.demo.configurator.model;

import lombok.Data;

/**
 * Created by jiangtao on 2019-03-20
 */
@Data
public class FeatureOption {

    public FeatureOption() {
    }

    public FeatureOption(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String description;

    private String code;

    private Boolean def = false;

    private Boolean multiple = false;

    public static FeatureOption newInstance(String code, String description, Boolean def, Boolean multiple) {
        FeatureOption option = new FeatureOption(code, description);
        option.setDef(def);
        option.setMultiple(multiple);
        return option;
    }
}
