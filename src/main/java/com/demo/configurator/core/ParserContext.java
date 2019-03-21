package com.demo.configurator.core;

import java.util.List;

/**
 * Created by jiangtao on 2019-03-20
 */
public class ParserContext {

    private List<RuleConfig> ruleConfigs;

    public ParserContext(List<RuleConfig> ruleConfigs) {
        this.ruleConfigs = ruleConfigs;
    }

    public List<RuleConfig> getRuleConfigs() {
        return ruleConfigs;
    }

}
