package com.demo.configurator.controller;

import com.demo.configurator.core.SampleDataProvider;
import com.demo.configurator.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiangtao on 2019-03-20
 */
@RestController
public class SampleController {

    @Autowired
    private SampleDataProvider sampleDataProvider;

    @GetMapping("/models")
    public List<Model> getModels() {
        return sampleDataProvider.getModels();
    }

}
