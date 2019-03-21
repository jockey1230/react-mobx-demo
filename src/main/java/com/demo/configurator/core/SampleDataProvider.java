package com.demo.configurator.core;

import com.demo.configurator.model.Feature;
import com.demo.configurator.model.FeatureOption;
import com.demo.configurator.model.Model;
import com.demo.configurator.model.Package;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiangtao on 2019-03-21
 */
@Component
public class SampleDataProvider implements InitializingBean {

    @Autowired
    private SampleRuleHandler sampleRuleHandler;

    private List<Model> models = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Model base = new Model("BASE");
        Feature doors = new Feature("DOORS", "");
        Feature windshield = new Feature("WINDSHIELD", "");
        Feature hvacCabin = new Feature("HVAC_CABIN", "");
        Feature whls = new Feature("WHLS", "");
        doors.setOptions(Arrays.asList(
                FeatureOption.newInstance("DR00", "", true, false)
        ));
        windshield.setOptions(Arrays.asList(
                FeatureOption.newInstance("WPR1", "", true, false)
        ));
        hvacCabin.setOptions(Arrays.asList(
                FeatureOption.newInstance("AC00", "", true, false)
        ));
        whls.setOptions(Arrays.asList(
                FeatureOption.newInstance("WH00", "", true, false),
                FeatureOption.newInstance("WH01", "", false, false)
        ));
        base.setFeatures(Arrays.asList(doors, windshield, hvacCabin, whls));

        models.add(sampleRuleHandler.parse(new Element(base), new ParserContext(null)));

        Model mid = new Model("MID");
        doors = new Feature("DOORS", "");
        windshield = new Feature("WINDSHIELD", "");
        hvacCabin = new Feature("HVAC_CABIN", "");
        whls = new Feature("WHLS", "");
        doors.setOptions(Arrays.asList(
                FeatureOption.newInstance("DR01", "", true, false)
        ));
        windshield.setOptions(Arrays.asList(
                FeatureOption.newInstance("WPR1", "", true, false),
                FeatureOption.newInstance("WPR2", "", false, false)
        ));
        hvacCabin.setOptions(Arrays.asList(
                FeatureOption.newInstance("AC00", "", true, false),
                FeatureOption.newInstance("AC01", "", false, false)
        ));
        whls.setOptions(Arrays.asList(
                FeatureOption.newInstance("WH02", "", true, false),
                FeatureOption.newInstance("WH03", "", false, false)
        ));
        mid.setFeatures(Arrays.asList(doors, windshield, hvacCabin, whls));

        Package package1 = new Package("PACK1", true);
        package1.setFeatures(Collections.singletonMap("DOORS", "DR01"));
        Package package2 = new Package("PACK2", false);
        package2.setFeatures(Collections.singletonMap("HVAC_CABIN", "AC01"));
        Package package3 = new Package("PACK3", false);
        package3.setFeatures(Collections.singletonMap("WINDSHIELD", "WPR2"));
        mid.setPackages(Arrays.asList(package1, package2, package3));

        models.add(sampleRuleHandler.parse(new Element(mid), new ParserContext(null)));

        Model high = new Model("HIGH");
        doors = new Feature("DOORS", "");
        windshield = new Feature("WINDSHIELD", "");
        hvacCabin = new Feature("HVAC_CABIN", "");
        whls = new Feature("WHLS", "");
        doors.setOptions(Arrays.asList(FeatureOption.newInstance("DR01", "", true, false)));
        windshield.setOptions(Arrays.asList(FeatureOption.newInstance("WPR2", "", true, false)));
        hvacCabin.setOptions(Arrays.asList(
                FeatureOption.newInstance("AC00", "", true, false),
                FeatureOption.newInstance("AC01", "", false, false)
        ));
        whls.setOptions(Arrays.asList(
                FeatureOption.newInstance("WH02", "", true, false),
                FeatureOption.newInstance("WH03", "", false, false),
                FeatureOption.newInstance("WH04", "", false, false)
        ));
        high.setFeatures(Arrays.asList(doors, windshield, hvacCabin, whls));

        package1 = new Package("PACK1", true);
        package1.setFeatures(Collections.singletonMap("DOORS", "DR01"));
        package2 = new Package("PACK2", false);
        package2.setFeatures(Collections.singletonMap("HVAC_CABIN", "AC01"));
        package3 = new Package("PACK3", true);
        package3.setFeatures(Collections.singletonMap("WINDSHIELD", "WPR2"));
        high.setPackages(Arrays.asList(package1, package2, package3));

        models.add(sampleRuleHandler.parse(new Element(high), new ParserContext(null)));
    }

    public List<Model> getModels() {
        return models;
    }
}
