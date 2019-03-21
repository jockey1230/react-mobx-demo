package com.demo.configurator.core;

import lombok.Data;

/**
 * Created by jiangtao on 2019-03-20
 */
@Data
public class Element {

    public Object source;

    public Element(Object source) {
        this.source = source;
    }
}
