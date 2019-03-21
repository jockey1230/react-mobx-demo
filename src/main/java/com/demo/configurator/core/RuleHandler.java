package com.demo.configurator.core;

import com.demo.configurator.model.Model;

/**
 * Created by jiangtao on 2019-03-20
 */
public interface RuleHandler {

    Model parse(Element element, ParserContext parserContext);

}
