package com.demo.configurator.core;

import com.demo.configurator.model.Model;
import org.springframework.stereotype.Component;

/**
 * Created by jiangtao on 2019-03-21
 */
@Component
public class SampleRuleHandler implements RuleHandler {

    @Override
    public Model parse(Element element, ParserContext parserContext) {
        return (Model) element.getSource();
    }

}
